# 🚀 Automacao API Tests

Framework de automação de testes de API desenvolvido em **Java + RestAssured + JUnit 5 + Maven**, com geração automática de evidências em PDF para cada execução de teste.

---

## 📌 Objetivo
Este projeto foi criado para validar endpoints REST garantindo:

- Validação de contrato
- Validação de status code
- Validação de payload
- Evidências automáticas
- Organização em camadas (Client / Service / Test / Utils)

---

## 🧱 Arquitetura do Projeto

src/test/java/com/api
│
├── assertions → Validações centralizadas
├── client → Camada HTTP (requisições)
├── core → Configurações base de teste
├── factory → Massa de dados
├── model → Objetos de domínio
├── service → Regras de negócio / chamadas
├── tests → Casos de teste
└── utils → Logger + geração de evidência PDF


---

## ⚙️ Tecnologias Utilizadas

- Java 21
- Maven
- RestAssured
- JUnit 5
- ReportLab (geração de PDF)
- Jackson (serialização JSON)

---

## ▶️ Como Executar os Testes

```bash
mvn test
📄 Evidências
Após execução, os relatórios são gerados automaticamente em:

/reports/pdf
Cada teste gera um PDF contendo:

Nome do teste

Data/hora execução

Steps executados

Status de cada step

Request e Response

Resultado final

🧪 Padrão de Teste
Exemplo:

@Test
void deveCriarUsuarioComSucesso() {
    User user = UserFactory.usuarioValido();

    Response response = UsuarioService.criarUsuario(user);

    ResponseValidator.statusCode(response, 201);
    ResponseValidator.message(response, "Cadastro realizado com sucesso");
    ResponseValidator.notNull(response, "_id");
}
📊 Logs de Execução
O framework registra automaticamente:

Request

Response

Tempo de resposta

Status

Tudo é salvo e exportado para o PDF de evidência.

🧠 Boas Práticas Implementadas
✔ Separação de responsabilidades
✔ Reutilização de código
✔ Massa dinâmica de teste
✔ Assertions reutilizáveis
✔ Evidência automática
✔ Estrutura escalável

👨‍💻 Autor
Projeto desenvolvido para fins de estudo, prática e demonstração de habilidades em automação de testes de API.

📜 Licença
Uso livre para estudos e melhorias.
