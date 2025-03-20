# Estrutura do Domain Model

## Principais Agregados e Entidades

### Cliente (Client)
- ID (VAT Number único)
- Nome da Empresa
- Endereço
- Lista de Representantes (CustomerRepresentative)
- Status do Cliente (Regular, VIP, Infringement, etc.)
- Lista de Pedidos de Show (ShowRequest)

### Representante do Cliente (CustomerRepresentative)
- ID
- Nome
- Email
- Telefone
- Cargo/Função

### Usuário do Sistema (User)
- ID (Email da Shodrone)
- Nome
- Telefone
- Role (Admin, CRM Manager, CRM Collaborator, Show Designer, Drone Tech)
- Status (Ativo/Inativo)
- Autenticação

### Show
- ID
- Cliente (Client)
- Lista de Figuras (Figure)
- Número de Drones
- Duração
- Status (Planejado, Em Produção, Concluído)
- Data e Hora

### Figura (Figure)
- ID
- Código DSL
- Descrição
- Categoria
- Versão
- Tipo (Estática/Dinâmica)
- Cliente (Se for exclusiva)
- Lista de Drones envolvidos

### Drone
- ID (Serial Number)
- Modelo
- Status (Ativo, Inativo, Em Manutenção)
- Programação específica (Código gerado a partir do DSL)

### Pedido de Show (ShowRequest)
- ID
- Cliente (Client)
- Local
- Data e Hora
- Número de Drones Solicitados
- Status (Aguardando Aprovação, Aprovado, Rejeitado)
- Exclusividade
- Lista de Figuras Solicitadas
- Documento de Proposta (Proposal)

### Simulação (Simulation)
- ID
- Show ou Figura a ser testada
- Resultado da Simulação (Aprovado/Reprovado)
- Relatório de Colisões
- Arquivo de Log

## Principais Relações
- **Cliente** tem **vários** **Representantes**
- **Usuário** pertence a um **único** **Role**
- **Cliente** pode ter **múltiplos** **Pedidos de Show**
- **Show** pode conter **múltiplas** **Figuras**
- **Figura** pode ser associada a **vários** **Drones**
- **Simulação** está ligada a um **Show ou Figura**
- **Drone** pertence a um **modelo específico**
- **CRM Manager** pode **aprovar/rejeitar** **Pedidos de Show**
- **Drone Tech** é responsável por **simulações e testes**

---

# Possíveis Ajustes no Domain Model

## 1. Usuário do Sistema (`User`)
- Pode ser **simplificado** ou até **omitido** no domain model, pois a autenticação/autorização pode ser tratada externamente via um serviço de autenticação.
- Se o sistema for responsável por gerenciar usuários internamente (CRUD de usuários), então faz sentido manter.

## 2. Representante do Cliente (`CustomerRepresentative`)
- Poderia ser apenas uma **lista de contatos** dentro da entidade `Cliente`, sem precisar de uma entidade separada.
- Se houver operações específicas para representantes (ex: login, submissão de pedidos), faz sentido mantê-lo.

## 3. Simulação (`Simulation`)
- Pode ser mais um **serviço** do que uma entidade, já que é um processo que valida **figuras/shows**.
- Se o sistema precisa armazenar resultados de simulações para referência futura, então deve ser mantida como entidade.

## 4. Pedido de Show (`ShowRequest`)
- Talvez possa ser fundido com `Show`, mas dado que o fluxo inclui aprovações e modificações antes de ser um show confirmado, faz sentido como entidade separada.

---

# Conclusão
Se quisermos simplificar o modelo:
✅ **Remover ou externalizar `User`** se for tratado por um serviço de autenticação.
✅ **Fundir `CustomerRepresentative` com `Client`** se os representantes não tiverem muitas regras de negócio próprias.
✅ **Transformar `Simulation` num serviço** se não precisarmos armazenar resultados de testes a longo prazo.
