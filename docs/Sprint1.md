# Sprint 1 - User Stories Detalhadas

## US101 - Restrições Técnicas

**Descrição:**  
Como **Project Manager**, quero garantir que a equipe siga **as restrições técnicas e preocupações do projeto**.

### O que isso significa?
- Há **restrições técnicas** e **requisitos não funcionais** que a equipe deve respeitar.
- Isso inclui regras sobre **gestão do projeto**, **documentação**, **uso de ferramentas** e **tecnologias específicas**.

### O que fazer?
1. **Ler a seção 5** do documento do projeto (onde estão as restrições técnicas).
2. Garantir que **todas as user stories** implementadas sigam essas regras.
3. Documentar as decisões técnicas no repositório do GitHub.

### Exemplo prático:
- O projeto exige **uso de GitHub para versionamento**, então não se pode usar outra ferramenta como Bitbucket ou GitLab.
- É obrigatório usar **Java como linguagem principal**, então não se pode desenvolver tudo em Python.

---

## US102 - Repositório do Projeto

**Descrição:**  
Como **Project Manager**, quero garantir que a equipe **use um repositório GitHub** e configure uma ferramenta de **gerenciamento de projeto**.

### O que isso significa?
- O projeto deve estar em um repositório GitHub **fornecido pela instituição**.
- Deve-se configurar um **quadro de tarefas** no GitHub para gerenciar o progresso.

### O que fazer?
1. Criar **um repositório GitHub** para o projeto.
2. Configurar o **quadro de gerenciamento** no GitHub Projects:
   - Criar **tarefas** para cada user story.
   - Atribuir tarefas aos membros da equipe.
   - Atualizar o status das tarefas (To Do, In Progress, Done).
3. Garantir que **todas as alterações** no código são feitas através de **commits e pull requests**.

### Exemplo prático:
- Criar um repositório no GitHub chamado **"Shodrone-Project"**.
- Criar um quadro "Kanban" no **GitHub Projects** com colunas "A fazer", "Em progresso" e "Feito".

---

## US103 - Estrutura do Projeto

**Descrição:**  
Como **Project Manager**, quero que a equipe **configure a estrutura do projeto** para facilitar o desenvolvimento futuro.

### O que isso significa?
- O código do projeto precisa ter uma estrutura bem definida.
- Isso inclui **organizar diretórios**, definir **módulos do sistema** e configurar **dependências**.

### O que fazer?
1. Criar a estrutura básica do código:
   ```
   Shodrone-Project/
   ├── src/
   │   ├── main/java/com/shodrone/
   │   │   ├── domain/   # Modelos de domínio (DDD)
   │   │   ├── services/ # Lógica de negócio
   │   │   ├── persistence/ # Comunicação com o banco de dados
   │   │   ├── application/ # Casos de uso e APIs
   │   │   ├── controllers/ # Camada de interface (REST, UI)
   ├── tests/  # Testes unitários e de integração
   ├── docs/   # Documentação do projeto
   ├── scripts/ # Scripts de automação
   ├── .github/ # Configuração do GitHub Actions
   ├── pom.xml  # Configuração do Maven
   ├── README.md # Documentação inicial do projeto
   ```

2. **Adicionar as dependências necessárias** (Exemplo: Maven ou Gradle para gerenciar pacotes).
3. **Configurar uma arquitetura escalável** (usar princípios de **DDD - Domain-Driven Design**).

---

## US104 - Servidor de Integração Contínua (CI/CD)

**Descrição:**  
Como **Project Manager**, quero configurar um **servidor de integração contínua**.

### O que isso significa?
- Toda vez que um desenvolvedor faz um **commit/push no GitHub**, o código deve ser automaticamente **compilado e testado**.

### O que fazer?
1. **Configurar o GitHub Actions** para compilar e testar o código:
   - Criar um arquivo **.github/workflows/build.yml**.
   - Adicionar um script para compilar o código com **Maven** e executar testes.
2. **Executar testes automáticos** em cada alteração de código.
3. Garantir que falhas na compilação/testes **bloqueiem** o merge no GitHub.

### Exemplo prático:
Criar um arquivo **`.github/workflows/build.yml`** no repositório:
```yaml
name: CI/CD Pipeline

on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - name: Checkout código
      uses: actions/checkout@v2

    - name: Configurar JDK 17
      uses: actions/setup-java@v2
      with:
        java-version: '17'
        distribution: 'temurin'

    - name: Compilar código
      run: mvn clean package

    - name: Executar testes
      run: mvn test
```

---

## US105 - Deployment Automatizado

**Descrição:**  
Como **Project Manager**, quero que o projeto tenha **scripts de automação** para facilitar **deploy e execução**.

### O que fazer?
1. Criar scripts **Bash** para Linux e **Batch/Powershell** para Windows.
2. Incluir comandos para:
   - **Compilar o projeto** (`mvn clean package`).
   - **Executar a aplicação** (`java -jar nome-do-arquivo.jar`).
   - **Deploy em um servidor** (Exemplo: Docker, Kubernetes).

### Exemplo prático:
Criar um script **deploy.sh**:
```bash
#!/bin/bash
echo "Compilando o projeto..."
mvn clean package

echo "Executando aplicação..."
java -jar target/minha-aplicacao.jar
```

---

## US110 - Modelo de Domínio (DDD)

**Descrição:**  
Como **Project Manager**, quero que a equipe crie um **Modelo de Domínio** baseado em **DDD (Domain-Driven Design)**.

### O que fazer?
1. Criar **classes Java** para os conceitos principais:
   ```java
   public class Cliente {
       private String nome;
       private String email;
       private String telefone;
   }
   ```
2. Criar **diagramas UML** para representar as relações entre os elementos do sistema.

### Exemplo prático:
- Criar um **diagrama UML** com as relações entre **Clientes, Figuras, Drones**.

---


