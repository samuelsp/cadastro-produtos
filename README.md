# Sistema de Gerenciamento de Produtos e Categorias

## Descrição
Este projeto é uma aplicação Java desenvolvida para gerenciar produtos e categorias de forma simples e eficiente. A aplicação possui interface gráfica baseada em menus para realizar operações de Criar, Ler e Atualizar produtos e suas respectivas categorias.
Este projeto foi realizado como parte do aprendizado obtido no curso Java Development da FIAP (Nano Courses).

## Tecnologias Utilizadas
- **Java**: Linguagem de programação principal (versão 18+)
- **Maven**: Gerenciamento de dependências e build do projeto
- **Swing**: Framework para interface gráfica
- **Padrão Repository**: Para persistência dos dados. Esta aplicação não utiliza banco de dados. A persistência é realizada em lista.

## Como Executar

### Pré-requisitos
- JDK 18 ou superior instalado
- Maven instalado
- Git instalado (opcional)

### Passos
1. Clone o repositório ou baixe o código fonte:
   ```bash
   git clone https://github.com/samuelsp/cadastro-produtos
   
### Acesse a pasta do projeto:  
- cd cadastro-produtos

### Compile o projeto:  
- mvn clean install

### Execute a aplicação:  
- mvn exec:java 

### Objetivo

A aplicação oferece as seguintes funcionalidades:  
- Cadastro de novas categorias
- Cadastro de novos produtos
- Alteração de produtos existentes
- Consulta de produtos por ID
- Consulta de produtos por categoria

A solução foi desenvolvida para demonstrar boas práticas de programação Java, incluindo:
- Organização em camadas (MVC)
- Uso do padrão de projeto (Repository)
- Interface gráfica intuitiva
- Tratamento de exceções
- Testes unitários
