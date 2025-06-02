# 💡 Controle de LED com Arduino e Spring Boot

Este projeto permite ligar e desligar um LED conectado a um Arduino por uma interface web. Cada ação é registrada em um banco de dados MySQL e exibida em uma tabela de histórico na mesma página.

---

## 🔧 Tecnologias

- Java 11  
- Spring Boot (Web, MVC, JPA, Thymeleaf)  
- MySQL  
- Maven  
- jSerialComm (comunicação com Arduino)  
- HTML + CSS (responsivo)  
- Arduino UNO  

---

## ✅ Funcionalidades

- Interface web para ligar/desligar o LED  
- Mudança de cor da tela (verde: ligado | vermelho: desligado)  
- Histórico de ações com data e hora  
- Botão para limpar todos os registros  
- Integração com Arduino via porta COM  
- Registro dos eventos em banco de dados  

---

## ⚙️ Configuração do Banco de Dados

1. Crie o banco:

CREATE DATABASE led_db;

2. O Spring Boot criará a tabela automaticamente ao iniciar o projeto.

---

## ▶️ Como Executar

1. Clone o repositório:

git clone https://github.com/seu-usuario/led-controller.git
cd led-controller

2. Configure seu application.properties com os dados do MySQL

3. Execute:

mvn spring-boot:run

4. Acesse no navegador:

http://localhost:8080

> Certifique-se de que:
> - O Arduino está conectado na porta COM correta (default: COM4)  
> - O código Arduino está carregado corretamente  
> - O Monitor Serial do Arduino IDE esteja fechado

---

## 👨‍💻 Autor

Projeto acadêmico desenvolvido por [Vicenzo de Souza]  
Ciência da Computação — Universidade Franciscana (UFN)
