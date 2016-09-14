Plano de Gerência de Configuração
=================================

Sumário
-------

<!-- TOC depthFrom:2 depthTo:4 withLinks:1 updateOnSave:1 orderedList:0 -->

- [1. Introdução](#1-introduo)
- [2. A Gerência de Configuração](#2-a-gerncia-de-configurao)
	- [2.1. Organização, Responsabilidades, e Interfaces](#21-organizao-responsabilidades-e-interfaces)
	- [2.2 Artefatos da Gerência de Configuração](#22-artefatos-da-gerncia-de-configurao)
	- [2.3. Ferramentas e Tecnologias](#23-ferramentas-e-tecnologias)

<!-- /TOC -->

## 1. Introdução
O Plano de Gerência de Configuração apresenta todas as tarefas do
Gerenciamento de Configuração e mudanças no projeto, para garantir a sua
integridade e o mantendo o domínio das mudanças ocorridas durante o
desenvolvimento. Nesse documento detalha-se toda a infra-estrutura
utilizada nesse projeto.

## 2. A Gerência de Configuração
### 2.1. Organização, Responsabilidades, e Interfaces
A gerência de configuração faz um papel fundamental para que o
desenvolvimento não seja prejudicado por informações inconsistentes.
Dessa forma, o gerente de configuração é responsável por controlar todas
as mudanças e disponibilizar a todos os envolvidos as versões e os itens
de configuração corretos e íntegros (artefatos de software) para que
inconsistências não atrapalhem a evolução do desenvolvimento (auditoria
das configurações) e permita uma melhor comunicação entre os membros da
equipe.

Gerentes de Configuração (GCOs):

> * Nome 1
> * Nome 2
> * Nome 3

Os gerentes de configuração devem ser remanejados a cada 15 dias.

### 2.2 Artefatos da Gerência de Configuração

* [Código fonte](../)
* [Repositório Wiki](./)
* [Baselines](../releases)
* [Banco de dados de Requisições de Mudança (Issues)](../issues)

### 2.3. Ferramentas e Tecnologias

| Tipo | Ferramenta | Versão |
|------|------------|--------|
| Controle de versão | [Git](http://git-scm.com) | 2.4.2 ou superior |
| Cliente Git (GUI) | [SmartGit](http://www.syntevo.com/smartgit) | 7.1.4 ou superior |
| Repositório de código-fonte | [GitHub](../) |   |
| Plataforma de programação | [Java (JDK)](http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html) | 1.8 |
| Ambiente de Desenvolvimento (IDE) | [IntelliJ IDEA Community](https://www.jetbrains.com/idea) | 2016 ou superior |
| Repositório de documentação | [GitHub Wiki](./) |   |
| Editor de texto *Markdown* | [Atom](http://atom.io) | 1.8.0 ou superior |
| Editor de diagramas | [Astah Community]() | 6.9.0 ou superior |
| Editor de Imagens |[GIMP](http://www.gimp.org/) | 2.8.0 ou superior |
| Editor de Desenho Vetorial |[Inkscape](https://inkscape.org) | 0.48.0 ou superior |
| Controle de mudanças | [GitHub Issues](../issues) |   |
| Gerência de projeto | [GitHub Projects](../projects) |   |
