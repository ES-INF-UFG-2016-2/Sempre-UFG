#                        ***Plano de Gerencia de Configuração***

------------------------------
#1. Introdução
------------------------------

A finalidade deste plano se refere à configuração do projeto, citando as regras e objetivos que deverão ser cumpridos para garantir o controle de versionamento dos artefatos gerados no projeto.

------------------------------
#2. Identificação da Configuração
------------------------------

São considerados itens de configuração todos os itens que apresentam relevância para o projeto:

* Todos os artefatos da EAP;

* Planos;

* Planilhas;

* Modelos;

* Diagramas;

* Componentes;

* Componentes de Teste;

* Executáveis;

* Imagens;

* Relatórios.

------------------------------
#3. Responsabilidades
------------------------------

Os responsáveis pela execução das atividades de Gerenciamento da Configuração estão descritos a seguir:

* Diretamente:
    * Gerente de Projeto: Julianny Alves;
    * Gerencia: Breno Fernandes e Gleibson Silva.

* Indiretamente:
    * Gerente de Verificação e Validação: Yuri Dias;
    * Gerente de Desenvolvimento: Leonardo Freitas.

A gerência de configuração faz um papel fundamental para que o desenvolvimento não seja prejudicado por informações inconsistentes, assim o gerente de configuração é responsável por controlar todas as mudanças e disponibilizar a todos os envolvidos as versões e os itens de configuração corretos e íntegros (artefatos de software) para que falhas do tipo não atrapalhem a evolução do desenvolvimento (auditoria das configurações).

------------------------------
#4. Identificação de Artefatos
------------------------------

Todos os artefatos gerados, com exceção de código fonte, neste projeto terão a seguinte nomenclatura:

SysRadoc_<TEXTO_LIVRE> - <TIPO_ART>.<EXT>

* Identificador	Descrição
**<TEXTO_LIVRE>** (Não obrigatório)	Texto livre que identifique unicamente o arquivo. Ex.: Reunião 01.
* **<TIPO_ART>**	Tipo do artefato. Ex: Ata, EAP, Diagrama de Caso de Uso, etc.
* **<EXT>**	A extensão do arquivo. Ex.: doc, xls, java, etc.3.1.2 Baselines do Projeto

Para que se dê a criação de uma baseline, é necessário que o gerente de configuração faça uma Auditoria de Configuração primeiro e autorize a criação dessa baseline, haja vista que o mesmo estará envolvido em todas as etapas do projeto, sendo este responsável por preparar o ambiente em que os artefatos serão versionados.

------------------------------
#5. Ferramentas, Ambiente e Infra-estrutura
------------------------------

As ferramentas utilizadas são:

* Editores: Google Docs;
* Controle de Versão:	Bitbucket, Wiki; 
* Modelagem: Draw.io, Astah Professional, Astah Comumunity, Corel Draw;
* Construção: InteliJ, Atom, Npm, Bower;
* Teste: Cucumber, Protactor, Sublime;
* Comunicação:	Hangouts, Whatsapp;	

O versionamento da configuração ficará a cargo da ferramenta de controle de versão Bitbucket (Git), tanto para artefatos de desenvolvimento (código fonte, diagramas, etc), quanto para documentos de Gerência (planos, planilhas, matrizes, etc), ou seja, todos os artefatos da EAP. 

Todavia, a infraestrutura do repositório foi criada de modo a separar documentos de cunho gerencial, dos artefatos de mais baixo nível como código-fonte, contendo em cada caso, uma separação entre áreas para facilitar a localização dos artefatos.

A ferramenta de controle de versão conta com uma estrutura que possibilita de divisão dos artefatos contidos na EAP:

***Gerência do Projeto***

 * **Gerência de Projeto (GPR)**
     * [Plano de Gerência do Projeto](Plano de Gerência do Projeto)
     * [Plano de Gerência de Configuração](Plano de Gerência de Configuração)
     * [Plano de Monitoramento e Controle](Plano de Monitoramento e Controle)
     * [Plano de Gerenciamento de Impacto](Plano de Gerenciamento de Impacto)
 * **Verificação, Validação e Qualidade (VV&Q)**
     * [Plano de Verificação, Validação e Qualidade](Plano de Verificação, Validação e Qualidade)
     * ***Documentos de Rotinas***
         * [Documento de Rotinas - Gerência de Projeto](Documento de Rotinas - Gerência de Projeto)
         * [Documento de Rotinas - Requisitos](Documento de Rotinas - Requisitos)
         * [Documento de Rotinas - Arquitetura](Documento de Rotinas - Arquitetura)
         * [Documento de Rotinas - Código](Documento de Rotinas - Código)

### Execução

 * **Pacote 1**
    * **Gerência de Projeto (GPR)**
        * [Relatório de Avaliação - Pacote 1](Relatório de Avaliação - Pacote 1)
    * Requisitos
        * [Documento de Modelos de negócio](Documento de Modelos de negócio)
        * [Documento de Especificação de Requisitos - Pacote 1](Documento de Especificação de Requisitos - Pacote 1)
    * Arquitetura de Software (ARQ)
        * [Documento de Arquitetura de Software - Pacote 1](Documento de Arquitetura de Software - Pacote 1)
    * **Verificação, Validação e Qualidade (VV&Q)**
        * [Relatório final de VV&Q - Pacote 1](Relatório final de VV&Q - Pacote 1)

 * **Pacote 2**
    * **Gerência de Projeto (GPR)**
        * [Relatório de Avaliação - Pacote 2](Relatório de Avaliação - Pacote 2)
    * Requisitos
        * [Documento de Especificação de Requisitos - Pacote 2](Documento de Especificação de Requisitos - Pacote 2)
    * Arquitetura de Software (ARQ)
        * [Documento de Arquitetura de Software - Pacote 2](Documento de Arquitetura de Software - Pacote 2)
    * **Verificação, Validação e Qualidade (VV&Q)**
        * [Relatório final de VV&Q - Pacote 2](Relatório final de VV&Q - Pacote 2)

 * **Pacote 3**
    * **Gerência de Projeto (GPR)**
        * [Relatório de Avaliação - Pacote 3](Relatório de Avaliação - Pacote 3)
    * Requisitos
        * [Documento de Especificação de Requisitos - Pacote 3](Documento de Especificação de Requisitos - Pacote 3)
    * Arquitetura de Software (ARQ)
        * [Documento de Arquitetura de Software - Pacote 3](Documento de Arquitetura de Software - Pacote 3)
    * **Verificação, Validação e Qualidade (VV&Q)**
        * [Relatório final de VV&Q - Pacote 3](Relatório final de VV&Q - Pacote 3)

### Definições, Acrônimos e Abreviações
 * [Glossário do SysRadoc](Glossário do SysRadoc)

Obs.: Não é vetado á equipe que façam seu workspaces em máquinas pessoais ou ambientes de trabalho. Também não há restrições de tamanho para os dados, desde que tenham conteúdo servível ao projeto e sigam as boas práticas de armazenamento.

O repositório criado para este projeto pode ser encontrado no ambiente [Bitbucket - SysRadoc](https://bitbucket.org/SysRadocTeam/sysradoc). 

------------------------------
#6. Baselines
------------------------------

As baselines possuem um padrão oficial no qual os trabalhos subseqüentes são baseados, onde somente mudanças autorizadas podem ser efetuadas.

Assim sendo, as baselines deverão ser criadas ao fim de cada iteração especificada no [Plano de Gerenciamento de Projeto](https://bitbucket.org/SysRadocTeam/sysradoc/wiki/Plano%20de%20Ger%C3%AAncia%20do%20Projeto). Após o lançamento da baseline, sua edição só poderá ser efetuada com a aprovação do Gerente de Projeto.

A autorização da baseline é de responsabilidade do Gerente de Projeto e deve conter toda a estrutura de diretórios criada até o momento pela equipe e gerencia, conforme este plano.

------------------------------
# 7. Treinamento e Recursos
------------------------------

No README do repositório principal há um guia rápido para utilização do sistema de controle de versão Git;
No site do GitHub há um tutorial iterativo para aprender a usar o Git em 15 minutos, criado pelo Code School: https://try.github.io
A documentação online do Git tem diversos conteúdos a respeito de controle de versão e gerência de configuração de forma completa, mas didática: http://git-scm.com/doc
Nos guias online do GitHub tem um guia rápido para aprendizagem da linguagem de marcação Markdown: https://guides.github.com/features/mastering-markdown/
