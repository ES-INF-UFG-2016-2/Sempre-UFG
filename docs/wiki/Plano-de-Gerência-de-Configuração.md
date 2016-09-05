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
    * Gerente de Projeto: ;
    * Gerencia: .

* Indiretamente:
    * Gerente de Verificação e Validação: ;
    * Gerente de Desenvolvimento: .

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
* Controle de Versão:	GitHub, Wiki; 
* Modelagem: Draw.io, Astah Professional, Astah Community, Corel Draw;
* Construção: InteliJ, Atom, Npm, Bower;
* Teste: Cucumber, Protactor, Sublime;
* Comunicação:	Hangouts, Whatsapp;	

O versionamento da configuração ficará a cargo da ferramenta de controle de versão GitHub (Git), tanto para artefatos de desenvolvimento (código fonte, diagramas, etc), quanto para documentos de Gerência (planos, planilhas, matrizes, etc), ou seja, todos os artefatos da EAP. 

Todavia, a infraestrutura do repositório foi criada de modo a separar documentos de cunho gerencial, dos artefatos de mais baixo nível como código-fonte, contendo em cada caso, uma separação entre áreas para facilitar a localização dos artefatos.

O repositório será dividido em **cinco branches**:

**master:** branch que contém a versão com todos os artefatos do projeto validados pelos grupos.

**homolog:** tem o objetivo de integrar as branches de todos os grupos. Nesta branch será feita uma avaliação e refatoração(caso necessário) dos artefatos antes que sejam colocados na branch master.

**grupo1:** branch de desenvolvimento do grupo 1.

**grupo2:** branch de desenvolvimento do grupo 1.

**grupo2:** branch de desenvolvimento do grupo 1.



### Execução


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
