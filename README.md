# LabMedication API

O LabMedication é uma aplicação de gestão de administração de medicamentos para um sistema hospitalar. Esse repositório é o responsável pelo backend da aplicação, criando uma API para facilitar a integração do front para o usuário final.

## Técnicas e Tecnologias

Na criação do projeto foram utilizadas seguintes técnicas:
- POO (Programação Orientada a Objetos)
- REST API
- Kanban utilizando o Trello
- Git Flow

E as seguintes tecnologias:
- Java (versão 17)
- Spring Boot (versão 3.1.1)
- Maven (versão 3.9.2)
- Postgresql (versão 15)

## Execução

1. Clone este repositório
2. Instale as dependências do Maven
3. Rode o projeto
4. Utilize um cliente de requisições HTTP (Postman, Insomnia, Thunder Client, etc) para verificar os endpoints em http://localhost:8080

## Possíveis Melhorias

- Modificar o JSON para receber os dados em português
- Atualizar a forma como são tratados os erros do JSON (usar o message)

## Documentação

### Usuário (Médico)

<details>
<summary>POST /usuarios</summary>

<pre>
Cadastra usuário no sistema.
</pre>

| Campo | Obrigatório | Descrição
| - | - | -
| name | sim | Nome completo
| cpf | sim | 
| rg | sim | 
| birthdate | sim | No seguinte formato dd/MM/yyyy
| gender | sim | Genêro do médico
| email | sim | 
| password | sim | Senha do sistema
| telephone | sim | Telefone
| crm | sim | 
| nationality | sim | Naturalidade
| specialty | sim | CLINICO_GERAL, ANESTESISTA, DERMATOLOGIA, GINECOLOGIA, NEUROLOGIA, PEDIATRIA, PSIQUIATRIA ou ORTOPEDIA
| civilState | sim | SOLTEIRO, CASADO, SEPARADO, DIVORCIADO ou VIUVO

</details>

<details>
<summary>PUT /usuarios/{id}</summary>

<pre>
Atualiza cadastro de usuário com a identificação passada na URL.
</pre>

| Campo | Obrigatório | Descrição
| - | - | -
| name | sim | Nome completo
| cpf | sim | 
| rg | sim | 
| birthdate | sim | No seguinte formato dd/MM/yyyy
| gender | sim | Genêro do médico
| email | sim | 
| telephone | sim | Telefone
| crm | sim | 
| nationality | sim | Naturalidade
| specialty | sim | CLINICO_GERAL, ANESTESISTA, DERMATOLOGIA, GINECOLOGIA, NEUROLOGIA, PEDIATRIA, PSIQUIATRIA ou ORTOPEDIA
| civilState | sim | SOLTEIRO, CASADO, SEPARADO, DIVORCIADO ou VIUVO

</details>

<details>
<summary>PATCH /usuarios/{id}/senha</summary>

<pre>
Atualiza senha de usuário com a identificação passada na URL.
</pre>

| Campo | Obrigatório | Descrição
| - | - | -
| oldPassword | sim | Senha antiga
| newPassword | sim | Nova senha

</details>

### Paciente

<details>
<summary>POST /pacientes</summary>

<pre>
Cadastra paciente no sistema.
</pre>

| Campo | Obrigatório | Descrição
| - | - | -
| name | sim | Nome completo
| cpf | sim | 
| rg | sim | 
| birthdate | sim | No seguinte formato dd/MM/yyyy
| gender | sim | Genêro do médico
| email | sim |
| telephone | sim | Telefone
| nationality | sim | Naturalidade
| emergencyContact | sim | Contato de emergência
| allergiesList | não | Lista de alergias
| specialCaresList | não | Lista de cuidados especifícos
| healthplan | não | Convênio
| healthplanNumber | não | Número da carteira do convênio
| healthplanExpireDate | não | Validade da carteira do convênio
| addressId | sim | Identificador do cadastro de endereço

</details>

<details>
<summary>PUT /pacientes/{id}</summary>

<pre>
Atualiza cadastro do paciente com a identificação passada na URL.
</pre>

| Campo | Obrigatório | Descrição
| - | - | -
| name | sim | Nome completo
| cpf | sim | 
| rg | sim | 
| birthdate | sim | No seguinte formato dd/MM/yyyy
| gender | sim | Genêro do médico
| email | sim |
| telephone | sim | Telefone
| nationality | sim | Naturalidade
| emergencyContact | sim | Contato de emergência
| allergiesList | não | Lista de alergias
| specialCaresList | não | Lista de cuidados especifícos
| healthplan | não | Convênio
| healthplanNumber | não | Número da carteira do convênio
| healthplanExpireDate | não | Validade da carteira do convênio
| addressId | sim | Identificador do cadastro de endereço

</details>

<details>
<summary>GET /pacientes</summary>

<pre>
Busca todos pacientes. Possível utilizar o <i>query param</i> <b>nome</b> para trazer todos que contenham o texto no nome.
</pre>

</details>

<details>
<summary>GET /pacientes/{id}</summary>

<pre>
Busca o paciente com a identificação passada na URL.
</pre>

</details>

<details>
<summary>DELETE /pacientes/{id}</summary>

<pre>
Deleta o paciente com a identificação passada na URL.
</pre>

</details>

### Administração de Medicamentos

<details>
<summary>POST /medicamentos</summary>

<pre>
Cadastra o registro de administração de medicamento no sistema.
</pre>

| Campo | Obrigatório | Descrição
| - | - | -
| name | sim | Nome
| type | sim | CAPSULA, COMPRIMIDO, LIQUIDO, CREME, GEL, INALACAO, INJECAO ou SPRAY
| amount | sim | Quantidade (númerico)
| unit | sim | MILIGRAMA, MICROGRAMA, GRAMA, MILILITRO ou PORCENTAGEM
| observations | sim | Observações
| patient -> id | sim | Um objeto chamando patient com o campo id do paciente
| doctor -> id | sim | Um objeto chamando doctor com o campo id do usuário

</details>

<details>
<summary>PUT /medicamentos/{id}</summary>

<pre>
Atualiza o registro de administração de medicamento com a identificação passada na URL.
</pre>

| Campo | Obrigatório | Descrição
| - | - | -
| type | sim | CAPSULA, COMPRIMIDO, LIQUIDO, CREME, GEL, INALACAO, INJECAO ou SPRAY
| amount | sim | Quantidade (númerico)
| unit | sim | MILIGRAMA, MICROGRAMA, GRAMA, MILILITRO ou PORCENTAGEM
| observations | sim | Observações

</details>

<details>
<summary>GET /medicamentos/{id}</summary>

<pre>
Busca o registro de administração de medicamento com a identificação passada na URL.
</pre>

</details>

<details>
<summary>DELETE /medicamentos/{id}</summary>

<pre>
Deleta o registro de administração de medicamento com a identificação passada na URL.
</pre>

</details>

### Estatísticas

<details>
<summary>GET /estatisticas</summary>

<pre>
Retorna uma lista com o nome de todos pacientes e a quantidade de registros de medicamentos de cada um deles.
</pre>

</details>

### Endereço

<details>
<summary>POST /enderecos</summary>

<pre>
Cadastra um endereço no sistema.
</pre>

| Campo | Obrigatório | Descrição
| - | - | -
| cep | sim | CEP no formato XXXXX-XXX
| city | sim | Cidade
| state | sim | Estado
| street | sim | Logradouro
| number | sim | Observações
| complement | não | Complemento
| district | sim | Bairro
| reference | não | Ponto de referência

</details>

<details>
<summary>GET /enderecos</summary>

<pre>
Retorna todos endereços cadastrados no sistema.
</pre>

</details>