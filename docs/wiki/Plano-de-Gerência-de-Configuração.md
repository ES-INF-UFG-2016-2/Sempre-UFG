Plano de Gerência de Configuração
=================================

Sumário
-------

<!-- TOC depthFrom:2 depthTo:4 withLinks:1 updateOnSave:1 orderedList:0 -->

- [1. Introdução](#1-introduo)
	- [2. Organização, Responsabilidades, e Interfaces](#2-organizao-responsabilidades-e-interfaces)
		- [2.1. Responsabilidades dos GCOs](#21-responsabilidades-dos-gcos)
		- [2.2. Responsabilidades da equipe de desenvolvimento no GCO](#22-responsabilidades-da-equipe-de-desenvolvimento-no-gco)
	- [3. A Gerência de Configuração](#3-a-gerncia-de-configurao)
		- [3.1. Artefatos da Gerência de Configuração](#31-artefatos-da-gerncia-de-configurao)
		- [3.2. Ferramentas e Tecnologias](#32-ferramentas-e-tecnologias)
		- [3.3. Identificação da Configuração](#33-identificao-da-configurao)
		- [3.4. Commits](#34-commits)
		- [3.5. Branches](#35-branches)
		- [3.6. Estrutura dos Repositórios](#36-estrutura-dos-repositrios)
			- [3.6.1. Repositório principal](#361-repositório-principal)
			- [3.6.2. Repositório Wiki](#362-repositório-wiki)
		- [3.7. Controle de mudanças](#37-controle-de-mudanças)
		- [3.8. Baselines](#38-baselines)

<!-- /TOC -->

## 1. Introdução
O Plano de Gerência de Configuração apresenta todas as tarefas do
Gerenciamento de Configuração e mudanças no projeto, para garantir a sua
integridade e o mantendo o domínio das mudanças ocorridas durante o
desenvolvimento. Nesse documento detalha-se toda a infra-estrutura
utilizada nesse projeto.

### 2. Organização, Responsabilidades, e Interfaces
A gerência de configuração faz um papel fundamental para que o
desenvolvimento não seja prejudicado por informações inconsistentes.
Dessa forma, o gerente de configuração é responsável por controlar todas
as mudanças e disponibilizar a todos os envolvidos as versões e os itens
de configuração corretos e íntegros (artefatos de software) para que
inconsistências não atrapalhem a evolução do desenvolvimento (auditoria
das configurações) e permita uma melhor comunicação entre os membros da
equipe.

##### Gerentes de Configuração (GCOs)

| Grupo   | Gerente  de Configuração                     |
|---------|----------------------------------------------|
| Grupo 1 | **Gustavo Moraes dos Santos** @gustavosotnas |
| Grupo 2 | **Leonardo Freitas dos Santos** @leonardo-freitas-1995 |
| Grupo 3 |**Yuri Matheus Dias Pereira** @Yuri-M-Dias

#### 2.1. Responsabilidades dos GCOs

* Supervisionar andamento das branches;
* Fazer e controlar as issues (pacotes de trabalho);
* Aprovar solicitações de merges (Pull Requests) sem "commits quebrados" – commits com código-fonte com erros de compilação / nos testes;
* Manter o padrão de diretórios dos repositórios (organização);

#### 2.2. Responsabilidades da equipe de desenvolvimento no GCO

* Usar as ferramentas sugeridas (seção [3.2](#32-ferramentas-e-tecnologias));
* Seguir os padrões de commit, da estrutura de repositórios e branches;
* Usar as issues para gerência de atividades, e comunicação e rastreabilidade entre requisitos e código-fonte.
* Fazer milestones para registrar os marcos do projeto;
* Fazer a baseline no final de cada iteração.

### 3. A Gerência de Configuração

#### 3.1. Artefatos da Gerência de Configuração

A Gerência de Configuração trabalhará em alto nível sob os seguintes conjuntos de artefatos:

* [Código fonte](../)
* [Repositório Wiki](./)
* [Baselines](../releases)
* [Banco de dados de Requisições de Mudança (Issues)](../issues)

#### 3.2. Ferramentas e Tecnologias

##### Ferramentas

| Tipo | Ferramenta | Versão |
|------|------------|--------|
| Controle de versão | [Git](http://git-scm.com) | 2.4.2 ou superior |
| Cliente Git (GUI) | [SmartGit](http://www.syntevo.com/smartgit) | 7.1.4 ou superior |
| Repositório de código-fonte | [GitHub](../) |   |
| Plataforma de programação | [Java (JDK)](http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html) | 1.8 |
| Ambiente de Desenvolvimento (IDE) | [IntelliJ IDEA Community](https://www.jetbrains.com/idea) | 2016 ou superior |
| Integração contínua | [Travis CI](https://travis-ci.org) |    |
| Análise Estática de Qualidade de Código | [SonarQube]() |    |
| Repositório de documentação | [GitHub Wiki](./) |   |
| Editor de texto *Markdown* | [Atom](http://atom.io) | 1.8.0 ou superior |
| Editor de diagramas | [Astah Community]() | 6.9.0 ou superior |
| Editor de Imagens |[GIMP](http://www.gimp.org/) | 2.8.0 ou superior |
| Editor de Desenho Vetorial |[Inkscape](https://inkscape.org) | 0.48.0 ou superior |
| Controle de mudanças | [GitHub Issues](../issues) |   |
| Gerência de projeto | [GitHub Projects](../projects) |   |

##### Tecnologias

| Tipo | Tecnologia | Versão |
|------|------------|--------|
| Container de Desenvolvimento| [Apache Tomcat](http://tomcat.apache.org) | 7.33 ou superior |
| Linguagem de Programação | [Java](http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html) | 8 Update 91 |
| Framework Web | [Java Servlet](https://jcp.org/en/jsr/detail?id=315) | 3.0 ou superior  |
| Banco de Dados | [MariaDB](https://mariadb.org/) | 5.5 |
| Framework de Apresentação | [Java ServerFaces](https://javaserverfaces.java.net/) | 2.3.0 ou superior |
| Linguagem de Apresentação Dinâmica (Front-end) | [JavaScript](https://developer.mozilla.org/pt-BR/docs/Web/JavaScript) | EcmaScript3 ou superior |
| Framework de Estilo | [Twitter Bootstrap](http://getbootstrap.com/) | 3.0 ou superior |
| Framework de Conteúdo Dinâmico (Front-end)| [JQuery](https://jquery.com/) | 3.0 ou superior |

#### 3.3. Identificação da Configuração

Todos os artefatos gerados no projeto – com exceção do código fonte no *repositório principal* – terão o seguinte método de identificação:

`<Tipo_do_artefato>_<Identificador>.<ext>`

| Identificador | Descrição |
|---------------|-----------|
| `<Tipo_do_artefato>` | Tipo do artefato. Ex.: *"Processo de...", "Diagrama de Classes", "Protótipo"*, etc.
| `<Identificador>` | Algum número, data ou frase que identifique unicamente o arquivo. Ex.: *"121", "18-02-2016", "Avaliação de Provas"*, etc.
| `<ext>` | A extensão do arquivo. Ex.: *png, ep, asta, bpm*, etc.

O código-fonte no *repositório principal* deve seguir os [convenções de código do Java](http://javascript.crockford.com/javacodeconventions.pdf) e os padrões da [Fábrica de Software do INF/UFG](http://fabrica.inf.ufg.br).

#### 3.4. Commits

##### Padrão de mensagem de commit

* Mensagem **sucinta** e **objetiva** sobre o conteúdo do commit
* Tamanho: de 15 a 50 caracteres
* Verbo na 3º pessoa do presente simples + complemento (o que mudou no projeto)
	* Exemplos:
		* `Adiciona diagrama de classes`
		* `Refatora função X`
		* `Otimiza funcionalidade "Enviar email"`
		* `Conserta bug #13`

##### Frequência de commit

* Pelo menos **1x por semana** por funcionalidade delegada ao membro da equipe.
* Os commits devem ser enviados ("pushados") ao repositório principal semanalmente. **Não devem ser feitos commits apenas localmente** na máquina do desenvolvedor, mesmo que eles tenham sido feitos na frequência estipulada acima.

#### 3.5. Branches

O repositório de código fonte deve ter no mínimo 5 branches:

| Branch | Descrição | Responsável (is) |
|--------|-----------|------------------|
| **`develop`** | branch de desenvolvimento de software dos grupos | [**@ES-INF-UFG-2016-2/GCOs**](https://github.com/orgs/ES-INF-UFG-2016-2/teams/GCOs) / [***@ES-INF-UFG-2016-2/grupo1***](https://github.com/orgs/ES-INF-UFG-2016-2/teams/grupo1) / [***@ES-INF-UFG-2016-2/grupo2***](https://github.com/orgs/ES-INF-UFG-2016-2/teams/grupo2) / [***@ES-INF-UFG-2016-2/grupo3***](https://github.com/orgs/ES-INF-UFG-2016-2/teams/grupo3)
| **`homolog`** |  tem o objetivo de integrar as branches de todos os grupos. Nesta branch será feita uma avaliação e refatoração (caso necessário) dos artefatos antes que sejam colocados na branch **master**. | [**@julianolopes**](https://github.com/julianolopes) /  [**@ES-INF-UFG-2016-2/GCOs**](https://github.com/orgs/ES-INF-UFG-2016-2/teams/GCOs)
| **`master`**  | branch que contém a versão com todos os artefatos do projeto validados pela equipe (branch padrão). | [**@julianolopes**](https://github.com/julianolopes)

##### Branches dos grupos

As branches `G1`, `G2` e `G3` são bloqueadas para fazer *push*. Para enviar commits para essas branches é necessário fazer o seguinte procedimento:

1. O integrante que está em determinado grupo cria uma "**branch temporária**" para seu uso próprio a partir da branch de seu grupo. <br> A branch deve ter como nome:
	* *O prefixo de* ***nome da branch do grupo*** *+ o nome da tarefa / requisito / funcionalidade que será feita nela.*  
	Exemplos:
		* `G1-RF-ExecCons`
		* `G3-RD-AprovDivulgInfo`
2. Na nova branch, o integrante trabalha no projeto (faz commits na sua branch)
3. Quando termina, integrante faz **solicitação de mudança** para a branch do seu grupo – "**Pull Request**" ***(PR)*** – e aguarda os [**GCOs**](https://github.com/orgs/ES-INF-UFG-2016-2/teams/GCOs) fazerem auditoria de configuração:
	* Se o *PR* é **aprovado**, commits do integrante vão para a branch do grupo;
	* Se ***reprovado***, *PR* é rejeitado e integrante deve corrigir (fazendo novos commits no *PR*).

##### Branch `master`

O **master** terá as seguintes regras para controle de commits:

* Apenas os GCOs poderão enviar commits para o **homolog**, e, após avaliação, para o **master**.
* Apenas os integrantes de sua respectiva equipe poderão enviar commits para a branch de seu grupo.

O fluxo de desenvolvimento de software com as cinco branches no repositório do **Sempre UFG** está ilustrado abaixo:

![Politica-de-GCO](./wiki/anexos/GCO/politica-de-branches/Politica-de-GCO.png)

#### 3.6. Estrutura dos Repositórios

##### 3.6.1. Repositório principal

##### Estrutura de pastas (Git)

> * ***anexos***
>    - ***Arquitetura***
>		+ *Arquivos de anexo para arquitetura (diagramas, planos)*
>    - ***Teste***
>		+ *Arquivos de anexo para testes*
> * ***db***
>    - ***ddl***
>		+ *Arquivos .sql de DDL*
>    - ***dml***
>		+ *Arquivos .sql de DML*
> * ***docs***
>    - ***wiki***
>		+ *Arquivos da wiki do repositório*
> * ***src***
>    - ***main***
>		+ ***resources***
>			* Recursos
>		+ ***java/br/ufg/inf/***
>			* ***abstratas***
>				* Classes abstratas
>			* ***config***
>				* Classes configurações
>			* ***dao***
>				* Classes de Data Access Object
>			* ***db***
>				* Classes de conexão ao banco
>			* ***enums***
>				* Classes de enum
>			* ***interfaces***
>				* Interfaces java
>			* ***modelo***
>				* Classes de entidade
>			* ***servico***
>				* Classes de serviço com regras de negócio
>			* ***servlet***
>				* Classes de comunicação HTTP
>			* ***utils***
>				* Classes utilitárias / ferramentas
>    - ***test***
>		+ ***resources***
>			* Recursos para testes
>		+ ***java/br/ufg/inf/***
>			* ***config***
>				* Classes que testam configurações configurações
>			* ***dao***
>				* Classes que testam persistência no banco
>			* ***db***
>				* Classes que testam conexão ao banco / scrips sql
>			* ***modelo***
>				* Classes que testam entidades
>			* ***servico***
>				* Classes que testam regras de negócio
>			* ***servlet***
>				* Classes que testam comunicação HTTP
>			* ***stubs***
>				* Stubs para testes

Qualquer alteração na estrutura de pastas (Como uma a necessidade de um novo pacote devido a uma classe não se encaixar a nenhum pacote da estrutura atual) deve ser discutido diretamente com um membro da equipe de GCO. O pedido de alteração na estrutura pode ser feito diretamente por comentário no Pull Request.

##### 3.6.2. Repositório Wiki

O repositório será acessado através do site e por repositório Git, no qual este deve seguir a seguinte estrutura:

##### Menu lateral (arquivo `_Sidebar.md`)

>### Gerência de Configuração
>* [Plano de Gerência de Configuração](Plano de Gerência de Configuração)
>
>### Engenharia de Requisitos
>* [Documento de Especificação de Objetivos e Requisitos (EOR)](Documento de Especificação de Objetivos e Requisitos (EOR))
>	* *Documento em PDF do professor Juliano*
>
>### Arquitetura
>* [Documento de Arquitetura de Software (DAS)](Documento de Arquitetura de Software (DAS))
>	* *Inclui imagens dos diagramas e esquemas de arquitetura*

##### Estrutura de pastas (Git)

> * ***Projeto***
>    - **Anexos**
>		+ *REQ*
>			* Projeto de interface
>    - **Extras**
>		+ *Identidade visual*
>		+ *Diversos*

> TO-DO pegar lista de artefatos de software (tipo "EAP")

#### 3.7. Controle de mudanças

* Gerenciamento de issues (também chamados de "**pacotes de trabalho**")
	* 4 principais tipos:
		* **Bug**
			* Tarefas para solicitar correção de defeitos no sistema detectados durante sua execução.
		* **Melhoria**
			* Tarefas que propõem uma manutenção de qualquer natureza no sistema.
		* **Nova funcionalidade**
			* Tarefas para implementar incrementos no escopo do sistema.
		* **Questionamento**
			* Issues para discutir questões relevantes sobre o negócio ou o projeto do sistema.
	* 4 situações:
		* Backlog (a fazer)
		* Em execução
			* Pode-se abrir questionamento (adiciona label e referencia usuário(s)).
		* Em homologação
			* Esperando análise de Pull Request.
		* Close
			* Implementada, validada e aprovada.
* Merges (Pull Requests)
	* Analisadas pelos GCO e ferramenta de Integração Contínua (CI).
		* GCOs usarão "Code Review" para relatar a análise

#### 3.8. Baselines

Para que se dê a criação de uma baseline, é necessário que os GCOs tenham feito a análise das tarefas feitas na iteração do projeto, e as ferramentas de testes automatizados, análises estáticas de código e integração contínua (CI) tenham aprovado todo o código-fonte até aquele ponto do projeto previamente.

##### Tag

As baselines serão "etiquetadas" com o seguinte formato, a partir do número 0 (zero):

`<major>.<minor>.<patch>`

E serão construídas com as seguintes orientações:

* Quebra de compatibilidade com versões anteriores, avança o `<major>`.
* Adição de novas funcionalidades sem quebrar compatibilidade com versões anteriores, avança o `<minor>`.
* Correção de bugs e outras alterações, avança `<patch>`.

*Semântica de versionamento baseada no "Semantic Versioning 2.0.0". Para mais informações, visite o site do* ***semver*** *na Internet [[iii]](#iii-semantic-versioning-v20-semver-disponivel-em-httpsemverorg-acesso-em-28-mar-2015).*

##### Notas de release

Ao criar uma nova baseline no projeto no [GitHub](http://github.com), há opção de colocar notas de release e anexar um arquivo executável do projeto em questão. As notas de release deverão ser feitas em texto na linguagem *Markdown* no seguinte esqueleto:

>### Histórico de mudanças
>
> * Novo: (...)
> * Correção: (...)
> * Melhoria: (...)
> * Menor: (...)

O repositório será versionado com versão `1.0` quando o software for lançado.
