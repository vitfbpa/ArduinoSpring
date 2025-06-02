package com.example.ledcontroller.service;

import com.example.ledcontroller.model.LedLog;
import com.example.ledcontroller.repository.LedLogRepository;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.OutputStream;
import java.util.List;

@Service
public class LedService {

    private SerialPort serialPort;
    private OutputStream output;
    private boolean ledOn = false;

    @Autowired
    private LedLogRepository logRepository;

    @PostConstruct
    public void init() {
        try {
            serialPort = SerialPort.getCommPort("COM5");
            serialPort.setComPortParameters(9600, 8, 1, 0);
            serialPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
            serialPort.openPort();
            output = serialPort.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toggleLed() {
        try {
            if (ledOn) {
                output.write('2');
                logRepository.save(new LedLog("OFF"));
            } else {
                output.write('1');
                logRepository.save(new LedLog("ON"));
            }
            ledOn = !ledOn;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isLedOn() {
        return ledOn;
    }

    public List<LedLog> getLogs(Sort sort) {
        return logRepository.findAll(sort);
    }

    public void clearLogs() {
        logRepository.deleteAll();
    }
}