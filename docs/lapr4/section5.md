# **Requisitos Não Funcionais - Explicação Detalhada**

## **NFR01 - Gestão do Projeto usando Scrum**

### **Explicação**
Scrum é uma metodologia ágil de gestão de projetos que permite desenvolver software de forma incremental e iterativa. No contexto deste projeto, Scrum será usado para planejar, monitorar e melhorar continuamente o desenvolvimento. 

O professor responsável por **LAPR4** atuará como **Scrum Master**, isto é, a pessoa responsável por garantir que a metodologia Scrum seja aplicada corretamente. O Scrum Master:
- Facilita reuniões e resolve obstáculos que a equipa enfrenta.
- Garante que as boas práticas de Scrum são seguidas.
- Ajuda a equipa a manter um ritmo sustentável de desenvolvimento.

Haverá uma **reunião semanal** de **Scrum** durante a aula **PL+OT** de LAPR4. Nessa reunião, a equipa discutirá:
1. **O que foi feito** na última semana.
2. **O que será feito** na próxima semana.
3. **Quais os obstáculos** que precisam ser resolvidos.

Além disso, um documento específico no **Moodle** fornece detalhes sobre como o Scrum será aplicado neste projeto.

---

## **NFR02 - Documentação Técnica**

### **Explicação**
Documentação técnica é essencial para garantir que o sistema possa ser compreendido, mantido e atualizado no futuro. Para isso, devem ser seguidas algumas regras:

1. **Localização da Documentação**  
   - Todos os documentos do projeto devem estar disponíveis na pasta `docs` dentro do repositório GitHub do projeto.
   - O formato dos documentos deve ser **Markdown (.md)**, pois é um formato leve e amplamente utilizado para documentação técnica.

2. **Modelagem com UML**  
   - Quando necessário, a documentação deve incluir diagramas UML (Unified Modeling Language).
   - Diagramas UML são representações visuais da arquitetura, design e fluxo de processos do sistema.

3. **Uso do PlantUML**  
   - O **PlantUML** é uma ferramenta para criar diagramas UML a partir de código-texto.
   - Os diagramas gerados pelo PlantUML devem ser armazenados no repositório de duas formas:
     - Como **arquivos-fonte**, para que possam ser editados no futuro.
     - Como **imagens PNG**, para que possam ser visualizados diretamente.

4. **Rastreabilidade do Processo de Desenvolvimento**  
   - Todas as fases do desenvolvimento de cada User Story (US) devem ser documentadas, incluindo:
     - **Análise** (o que precisa ser feito).
     - **Design** (como será feito).
     - **Implementação** (código-fonte e decisões técnicas).
     - **Testes** (como foi verificado que funciona corretamente).

---

## **NFR03 - Desenvolvimento Orientado a Testes (TDD)**

### **Explicação**
Test-Driven Development (**TDD**) é uma abordagem de desenvolvimento onde os testes são escritos **antes** da implementação do código.

### **Como funciona o TDD**
1. **Escreve-se um teste** para uma funcionalidade que ainda não existe.
2. **Executa-se o teste**, que irá falhar porque a funcionalidade ainda não foi implementada.
3. **Desenvolve-se o código** para fazer o teste passar.
4. **Executa-se o teste novamente** até que ele passe.
5. **Refatora-se o código** para melhorar sua qualidade sem alterar seu comportamento.
6. **Repete-se o ciclo** para cada nova funcionalidade.

### **Benefícios**
- Garante que todas as funcionalidades tenham testes automáticos.
- Melhora a qualidade do código.
- Evita regressões (erros causados por mudanças no código).

---

## **NFR04 - Controlo de Versão**

### **Explicação**
Todo o código-fonte e documentação do projeto devem ser armazenados num repositório GitHub. O controlo de versão é essencial para:
- Rastrear mudanças no código ao longo do tempo.
- Permitir que vários programadores trabalhem simultaneamente no mesmo projeto sem conflitos.
- Recuperar versões anteriores do código caso algo dê errado.

### **Regras**
1. **Usar o repositório GitHub fornecido pelo professor.**
2. **Trabalhar em branches separados**, mas garantir que todas as versões estáveis do projeto estejam na branch `main` ou `master`.

---

## **NFR05 - Integração Contínua**

### **Explicação**
A Integração Contínua (**Continuous Integration - CI**) é um processo automatizado que verifica continuamente se o código do projeto funciona corretamente. Neste projeto, isso será feito com **compilações noturnas (night builds)**, que:
- Verificam automaticamente se o código compila e se os testes passam.
- Geram métricas sobre a qualidade do código.
- Publicam os resultados no GitHub.

---

## **NFR06 - Deployment e Scripts**

### **Explicação**
O sistema deve incluir **scripts automatizados** para facilitar:
- **Compilação** (transformar código em um programa executável).
- **Deploy** (instalar o sistema em um ambiente real de produção).
- **Execução** (rodar o software de forma simples).

Estes scripts devem funcionar em **Linux** e **Windows**, e a documentação (`readme.md`) deve explicar como utilizá-los.

---

## **NFR07 - Configuração de Base de Dados**

### **Explicação**
O sistema deve permitir diferentes formas de armazenar os dados:

1. **Modo "In-Memory"**  
   - Os dados são armazenados apenas na memória RAM.
   - Rápido, útil para **testes e desenvolvimento**.
   - Mas os dados desaparecem quando o sistema é desligado.

2. **Banco de Dados Relacional (RDBMS)**  
   - Os dados são armazenados num banco de dados real (ex: MySQL, PostgreSQL).
   - Essencial para um ambiente de **produção**.
   - Deve ser possível configurar o sistema para iniciar com alguns dados padrão.

---

## **NFR08 - Autenticação e Autorização**

### **Explicação**
O sistema deve garantir que todos os utilizadores e funcionalidades sigam **regras de autenticação e autorização** para controlar acessos.

Isso pode ser feito utilizando **frameworks de autenticação** já existentes.

---

## **NFR09 - Linguagem de Programação**

### **Explicação**
A principal linguagem para a implementação do projeto deve ser **Java**. Outras linguagens podem ser usadas em requisitos específicos (exemplo: **C para a simulação dos drones**).

---

## **NFR10 - APIs de Sockets de Rede**

### **Explicação**
A comunicação entre sistemas pode ser feita:
1. **Usando um novo protocolo de aplicação** criado especificamente para este projeto.
2. **Utilizando um protocolo padrão já existente, como HTTP.**

---

## **NFR11 - DSL e Validação do Código dos Drones**

### **Explicação**
- O sistema usará uma **DSL (Domain-Specific Language)** para descrever os movimentos dos drones.
- A ferramenta **ANTLR** será usada para analisar e validar essa linguagem.

---

## **NFR12 - Simulação do Sistema**

### **Explicação**
- A simulação dos drones deve utilizar **processos e threads** para garantir que cada drone seja simulado independentemente.
- A comunicação entre processos será feita através de **memória compartilhada**.
- O sistema deve incluir **detecção de colisões**, **geração de relatórios** e **sincronização passo-a-passo**.
