![Status](https://img.shields.io/badge/STATUS-EM_DESENVOLVIMENTO-red?style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-green?style=for-the-badge&logo=springboot)
![Roadmap](https://img.shields.io/badge/Roadmap-EM_EVOLUÇÃO-purple?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)
# 💰 API de Controle Financeiro

API REST desenvolvida para gerenciamento de finanças pessoais, permitindo o controle de receitas, despesas e categorias de gastos.

Este projeto foi construído utilizando **Java** e **Spring Boot**, com foco em boas práticas de arquitetura e documentação.

---

> 🚧 **Nota:** Este projeto é um *Work in Progress* (Em andamento). Novas funcionalidades de segurança, regras de negócio e interface gráfica estão sendo implementadas gradualmente conforme meu avanço nos estudos.

---
## Tecnologias Utilizadas

- Java 21 
- Spring Boot 
- Spring Data JPA
- H2 Database
- Lombok
- SpringDoc OpenAPI (Swagger)
- Maven

---
## Funcionalidades

- **Gerenciamento de Usuários:** Cadastro, listagem, atualização e remoção.
- **Gerenciamento de Categorias:** Cadastro de categorias personalizadas.
    - Classificação por tipo: RECEITA ou DESPESA.
- **Lançamento de Receitas e Despesas:**
    - Registro de transações financeiras com data, valor e descrição.

---
## 🛠️ Como Executar o Projeto

### Pré-requisitos
- Ter o **Java 21** (JDK) instalado.
- Ter o **Maven** instalado (ou usar o wrapper incluso no projeto).

### Passo a passo
1. Clone este repositório:
   ```bash
   git clone [https://github.com/nataliadsnascimento/api-controle-financeiro.git](https://github.com/nataliadsnascimento/api-controle-financeiro.git)
2. Acesse a pasta do projeto:

   ```bash
   cd api-controle-financeiro
3. A aplicação iniciará na porta padrão 8080 (Documentação Swagger) .
   ```bash
   http://localhost:8080/swagger-ui.html
4. Banco de Dados H2 
   ```bash
   http://localhost:8080/h2-console

---

## Roadmap

Este projeto está em desenvolvimento contínuo e novas funcionalidades serão implementadas gradualmente. Abaixo estão as melhorias planejadas:

### Segurança & Autenticação
- [ ] **Criptografia de Senhas:** Implementar Hash de senhas.
- [ ] **Spring Security:** Configurar a proteção das rotas da API.
- [ ] **Token JWT:** Implementar autenticação *Stateless* (Login retorna um token de acesso).

### Regras de Negócio & Funcionalidades
- [ ] **Dashboard:** Criar endpoint que retorna o resumo financeiro (Total Receitas, Total Despesas, Saldo).
- [ ] **Filtros:** Adicionar busca por mês/ano nas listagens de receitas e despesas.
- [ ] **Paginação:** Implementar paginação nos endpoints `GET` para otimizar o retorno de muitos dados.

### Frontend (Interface Gráfica)
- [ ] **Integração:** Desenvolver o Frontend (framework React) consumindo esta API.

### DevOps
- [ ] **Deploy:** Publicar a API em um provedor de nuvem.