# Plano de Gerência de Configuração

## Índice Analítico

* 1. [Introdução e Finalidade](#1-introdução-e-finalidade)
    * 1.1 [Definições, Acrônimos e Abreviações](#11-definições-acrônimos-e-abreviações)
    * 1.2 [Referências](#12-referências)
* 2. [Gerenciamento de Configuração de Software](#2-gerenciamento-de-configuração-de-software)
    * 2.1 [Organização, Responsabilidades e Interfaces](#21-organização-responsabilidades-e-interfaces)
    * 2.2 [Ferramentas, Ambiente e Infra-estrutura](#22-ferramentas-ambiente-e-infra-estrutura)
* 3. [O Programa de Gerenciamento de Configuração](#3-o-programa-de-gerenciamento-de-configuração)
    * 3.1 [Identificação da Configuração](#31-identificação-da-configuração)
        * 3.1.1 [Métodos de Identificação](#311-métodos-de-identificação)
        * 3.1.2 [Baselines do Projeto](#312-baselines-do-projeto)
        * 3.1.3 [Estrutura do Repositório de Versões](#313-estrutura-do-repositório-de-versões)
    * 3.2 [Controle de Configuração e Mudança](#32-controle-de-configuração-e-mudança)
        * 3.2.1 [Processamento e Aprovação de Solicitações de Mudança](#321-processamento-e-aprovação-de-solicitações-de-mudança)
        * 3.2.2 [Comitê de Controle de Mudança (CCB)](#322-comitê-de-controle-de-mudança-ccb)
    * 3.3 [Estimativa do Status de Configuração](#33-estimativa-do-status-de-configuração)
        * 3.3.1 [Processo de Armazenamento de Mídia e Liberação do Projeto](#331-processo-de-armazenamento-de-mídia-e-liberação-do-projeto)
        * 3.3.2 [Relatórios e Auditorias](#332-relatórios-e-auditorias)
* 4. [Marcos do projeto](#4-marcos-do-projeto)
* 5. [Treinamento e Recursos](#5-treinamento-e-recursos)


## 1. Introdução e Finalidade
O Plano de Gerência de Configuração apresenta todas as tarefas do Gerenciamento de Configuração e mudanças no projeto, para garantir a sua integridade e o mantendo o domínio das mudanças ocorridas durante o desenvolvimento. Nesse documento detalha-se toda a infra-estrutura utilizada nesse projeto.

### 1.1 Definições, Acrônimos e Abreviações

|Termo   |Significado                                                                             |
|--------|----------------------------------------------------------------------------------------|
|IDE     |Ambiente de Desenvolvimento Integrado                                                   |
|GC      |Gerência de Configuração                                                                |
|Baseline|Conjunto de itens de configuração que conseguiram um estado comprovado de estabilidade. |

## 2. Gerenciamento de Configuração de Software
### 2.1 Organização, Responsabilidades e Interfaces

A gerência de configuração faz um papel fundamental para que o desenvolvimento não seja prejudicado por informações inconsistentes, assim o gerente de configuração é responsável por controlar todas as mudanças e disponibilizar a todos os envolvidos as versões e os itens de configuração corretos e íntegros (artefatos de software) para que falhas do tipo não atrapalhem a evolução do desenvolvimento (auditoria das configurações).

#### Artefatos da Gerência de Configuração x Atividades da Gerência de Configuração

As atividades da Gerência de Configuração estão definidas no MPS.BR nível F e são divididas em GCOs, que serão abrangidos e controlados nos artefatos gerados. Como o Scrum não contempla soluções nesta área explicitamente, adaptações foram feitas para que a gerência de configuração fosse implementada no processo.

|                      Artefatos                       |       Atividades       |
|------------------------------------------------------|------------------------|
| Plano de Configuração                                | GCO1, GCO2             |
| Repositório organizado para os Itens de Configuração | GCO1, GCO2, GCO3, GCO5 |
| Baselines                                            | GCO3,                  |
| Banco de dados de Requisições de Mudança (Issues)    | GCO4, GCO5             |

### 2.2 Ferramentas, Ambiente e Infra-estrutura

##### Ferramentas

|Tipo                                 |Ferramenta                                         |Versão     |
|-------------------------------------|---------------------------------------------------|-----------|
|Controle de Versão                   |[GIT](http://git-scm.com)                          |2.4.2      |
|Ambiente de Desenvolvimento (IDE)    |[NetBeans](http://netbeans.org)                    |8.1        |
|Gerenciamento de Projetos            |[waffle.io](http://waffle.io)                      |           |
|Editor de Texto                      |[Atom](http://atom.io)             |           |
|Editor de Diagramas                  |[draw.io](http://draw.io)                          |           |
|Editor de Imagens                    |[GIMP](http://www.gimp.org/)                       |2.8        |
|Editor de Desenho Vetorial           |[Inkscape](https://inkscape.org)                   |0.48.4     |
|Controle de mudanças                 |[GitHub Issues](http://github.com)                 |           |

3. O Programa de Gerenciamento de Configuração
----------------------------------------------
### 3.1 Identificação da Configuração

#### 3.1.1 Métodos de Identificação

Todos os artefatos gerados no projeto – com exceção do código fonte no *repositório principal* – terão a seguinte nomenclatura:

`<Tipo_do_artefato>_<Identificador>.<ext>`

| Identificador | Descrição |
|---------------|-----------|
| `<Tipo_do_artefato>` | Tipo do artefato. Ex.: *"Processo de...", "Diagrama de Caso de Uso", "Protótipo"*, etc.
| `<Identificador>` | Algum número, data ou frase que identifique unicamente o arquivo. Ex.: *"121", "18-02-2016", "Avaliação de Provas"*, etc.
| `<ext>` | A extensão do arquivo. Ex.: *png, ep, dia, bpm*, etc.

#### 3.1.2 Baselines do Projeto

Para que se dê a criação de uma baseline, é necessário que o gerente de configuração faça uma [Auditoria de Configuração](#332-relatórios-e-auditorias) primeiro e autorize a criação dessa *baseline*, haja vista que o mesmo estará envolvido em todas as etapas do projeto, sendo este responsável por preparar o ambiente em que os artefatos serão versionados.

##### Tag

As baselines, quando criadas, conterão todo o repositório Git, incluindo código fonte, diagramas, etc. e serão numeradas com o seguinte formato, a partir do número 0 (zero):

`<major>.<minor>.<patch>`

E serão construídas com as seguintes orientações:

* Quebra de compatibilidade com versões anteriores, avança o `<major>`.
* Adição de novas funcionalidades sem quebrar compatibilidade com versões anteriores, avança o `<minor>`.
* Correção de bugs e outras alterações, avança `<patch>`.

O repositório será versionado com versão `1.0` quando o software for lançado.

*Semântica de versionamento baseada no "Semantic Versioning 2.0.0". Para mais informações, visite o site do* ***semver*** *na Internet [[iii]](#iii-semantic-versioning-v20-semver-disponivel-em-httpsemverorg-acesso-em-28-mar-2015).*

##### Notas de release

Ao criar uma nova baseline no [GitHub](http://github.com), há opção de colocar notas de release e anexar um arquivo executável do projeto em questão. As notas de release deverão ser feitas em texto na linguagem *Markdown* no seguinte esqueleto:

```
### Histórico de mudanças

- *[Novo: (...)]*
- *[Correção: (...)]*
- *[Melhoria: (...)]*
- *[Menor: (...)]*
```

#### 3.1.3 Estrutura do Repositório de Versões

O [GitHub](http://github.com) será usado para armazenar o código-fonte e a documentação do **SempreUFG**. O código-fonte será desenvolvido em um repositório Git exclusivo para este fim. Os artefatos de documentação serão armazenados em um repositório específico para documentação online (Portal Wiki).

##### Repositório principal

O [repositório do **SempreUFG**](https://github.com/gustavosotnas/Sempre-UFG), podendo ser controlado pelo sistema de controle de versão [**GIT**](http://git-scm.com) ou **SVN**, deve ter os seguintes artefatos nos respectivos diretórios relacionados abaixo (em ordem alfabética):

|Diretório|Conteúdo                                                        |
|---------|----------------------------------------------------------------|
| **.** | • README do repositório </br> • Código fonte do projeto

###### Branches

O repositório será dividido em **cinco branches**:

| Branch | Descrição |
|--------|-----------|
| **master**  | branch que contém a versão com todos os artefatos do projeto validados pela equipe.
| **homolog** |  tem o objetivo de integrar as branches de todos os grupos. Nesta branch será feita uma avaliação e refatoração(caso necessário) dos artefatos antes que sejam colocados na branch **master**.
| **g1**  | branch de desenvolvimento do grupo 1
| **g2**  | branch de desenvolvimento do grupo 2
| **g3**  | branch de desenvolvimento do grupo 3

O **master** terá as seguintes regras para controle de commits:

* Apenas o professor e o gerente de configuração poderão enviar commits para o **master**, após avaliação feita pela equipe de homologação do projeto.
* Apenas os líderes de cada grupo de projeto poderão enviar commits para o **homolog**.
* Apenas os integrantes de sua respectiva equipe poderão enviar commits para a branch de seu grupo.

Os grupos são livres para criar **branches temporárias** da branch relacionada
à do seu grupo, com o prefixo do nome da branch do grupo. Exemplos:

- **g3-desenv**: branch criada para desenvolvimento de um método num código qualquer.
- **g1-#12**: branch criada para resolver uma possível issue **#12** para o grupo 1.

###### Commits

####### Padrão de commit

####### Frequência de commit

Os commits devem ser feitos pelo menos 1x por semana ou assim que o integrante do grupo. Não podem ser enviados commits com códigos que geram exceção ou com erros de compilação/sintaxe (commit "quebrado").

##### Repositório de documentação (Wiki)

O [Wiki do **SempreUFG**](https://github.com/gustavosotnas/Sempre-UFG/wiki), controlado apenas por [**GIT**](http://git-scm.com) e pelo GitHub de forma online, conterá apenas arquivos de texto na linguagem de marcação *Markdown* (.md), que serão exibidos on-line em HTML no navegador de Internet. Como o GitHub cria uma abstração de que é um *website* a documentação do repositório, não é exibido o formato de hierarquia de arquivos e pastas como no repositório principal.

Para estruturação do Wiki, a página principal ([Home](https://github.com/gustavosotnas/Sempre-UFG/wiki)) e a [barra lateral do Wiki](https://github.com/gustavosotnas/Sempre-UFG/wiki/_Sidebar) terão a divisão feita por "**Portais**", a exemplo dos [Portais do Wikipédia](http://pt.wikipedia.org/wiki/Portal:Índice), mas para áreas de conhecimento da Engenharia de Software aplicadas no projeto:

|Gerência de Projeto|Documentação relacionada ao gerenciamento do projeto|
|-------------------|----------------------------------------------------|
|Planejamento| • Plano de Projeto |
|Procedimentos| • Relatórios de Monitoramento |

|Gerência de Configuração|Documentação relacionada ao gerenciamento de itens de configuração do projeto|
|-------------------|----------------------------------------------------|
|Planejamento| • Plano de Gerência de Configuração |
|Procedimentos| • Relatórios de Auditorias de Configuração |

|Engenharia de Requisitos e Arquitetura|Documentação relacionada aos artefatos de elaboração do produto em alto nível |
|-------------------|----------------------------------------------------|
|Planejamento| • Documento de Especificação de Objetivos e Requisitos (EOR) </br> • Documento de Arquitetura de Software (DAS)|

|Verificação e Validação (V&V)|Documentação relacionada às atividades de V&V no projeto|
|-------------------|----------------------------------------------------|
|Planejamento| • Plano de Verificação e Validação |
|Procedimentos| • Documento de Procedimentos (para cada artefato escolhido no Plano para passar por V&V - exceto Planos Gerenciais) </br> • Relatório de Resultados (para cada artefato escolhido no Plano para passar por V&V - exceto Planos Gerenciais) |

|Manutenção|Documentação relacionada às atividades de Manutenção de software no projeto|
|-------------------|----------------------------------------------------|
|Planejamento| • Plano de Manutenção |

##### Documentos de anexo na Wiki

|Diretório|Conteúdo|
|---------|--------|
|***Processo*** | • Documento em PDF do Processo de Desenvolvimento de Software </br>
|***Projeto*** | *Diretório relacionado à artefatos diversos do projeto.*
|./anexos | Arquivos de imagem de itens exportados das ferramentas para uso no [Wiki](https://github.com/gustavosotnas/Sempre-UFG/wiki): </br> • Diagrama de Caso de Uso do ***SempreUFG***; </br> • Diagrama de Classes SempreUFG; </br> • Diagrama de Implantação ***SempreUFG***; </br> • Estrutura Analítica do Projeto (EAP) do ***SempreUFG*** </br> • Representação da Arquitetura - MVC; </br> • Tabela de Exposição de Riscos do Projeto ***SempreUFG***; </br> • Referências das imagens dos diagramas - README
|./anexos/ciclo de vida | • Arquivos de imagem do Ciclo de Vida do projeto ***SempreUFG***
|./anexos/registros de aprovação | • Arquivos de imagem com assinaturas à mão de integrantes da equipe ***SempreUFG*** |
|./extras | *Itens diversos relacionados ao projeto que não se encaixa em nenhuma das categorias montadas no repositório: Fotos, Vídeos, Apresentações, etc.*: </br> • Protótipo de Interface Gráfica (GUI) do aplicativo ***SempreUFG***
|./extras/ícone | • Arquivos de imagem do ícone do projeto e aplicativo ***SempreUFG*** |

### 3.2 Controle de Configuração e Mudança

#### 3.2.1 Processamento e Aprovação de Solicitações de Mudança

O repositório é mantido e controlado nas seguintes formas: em conjunto com os *Mantenedores* do software. A plataforma de ***Issues*** do GitHub é aonde serão feitas e registradas todas as atividades em relação à mudanças no software. As mesmas issues podem ser visualizadas na ferramenta de Gerenciamento de Projetos [waffle.io](http://waffle.io).

* Issues (Solicitação de Mudança / tarefas)
* Pull Requests ()

Quando alguém cria uma nova *issue* (reporta um *bug*, solicita uma nova funcionalidade), é feita uma análise de viabilidade e riscos. Se a mudança solicitada não é viável, é informada ao autor da solicitação a inviabilidade e é fechada a *issue*; caso contrário, os *Mantenedores* planejam e executam a mudança e o Gerente de Configuração e o de Verificação e Validação monitoram o procedimento. Caso a mudança feita tenha sido um sucesso (revisada), o gerente de configuração prepara mais uma *release* (*baseline*) do software.

#### 3.2.2 Comitê de Controle de Mudança (CCM)

O Comitê de Controle de Mudança (CCM) será responsável por avaliar o impacto, benefícios, riscos associados, além de aprovar e priorizar as mudanças submetidas para a reunião do CCB. É formada por representantes dos grupos, e juntos farão a gestão de mudanças do projeto, para ter uma organização sobre as solicitações de mudanças no ***SempreUFG***.

A gerente de projeto ficará responsável por redigir as Análises de Viabilidade e Riscos e o Planejamento de mudanças (caso sejam aprovadas), coordenar as reuniões, receber, organizar e comunicar informações referentes a mudanças e gerar a pauta, com antecedência de pelo menos um dia, e a ata com as decisões tomadas, disponibilizando-os em repositório único para manter um histórico de fácil acesso e consulta (seção [3.1.3](#313-estrutura-do-repositório-de-versões)).

Um *Template* para *issue* de **Solicitação de Mudança (SM)** está disponível no [Wiki do GitHub](https://github.com/gustavosotnas/Sempre-UFG/wiki) para padronizar as informações necessárias para uma solicitação de mudança.

A solicitação de mudança (SM) deve ser deve ser registrada nas ***Issues*** do GitHub, assim como as Análises de Viabilidade e Riscos e o Planejamento de mudanças, disponível no [repositório do projeto](https://github.com/gustavosotnas/Sempre-UFG/issues). Algumas informações são necessárias para a devida criação do solicitação.

### 3.3 Estimativa do Status de Configuração

#### 3.3.1 Processo de Armazenamento de Mídia e Liberação do Projeto

O [repositório do projeto](https://github.com/gustavosotnas/Sempre-UFG) deverá ser "clonado" por todos os integrantes da equipe de preferência em um diretório monitorado por um algum aplicativo de sincronização para nuvem (como [***Dropbox***](https://www.dropbox.com), [***MEGA***](https://mega.co.nz)) e caso algum imprevisto aconteça em algum computador de um integrante da equipe ou com o repositório, o conteúdo poderá ser recuperado pelo serviço de armazenamento em nuvem no qual estava o diretório do repositório Git.

O processo de liberação do projeto diz respeito ao conteúdo do **release**, a quem ele se destina e se há quaisquer problemas conhecidos e instruções de instalação. Mais informações no seção [3.1.2](#312-baselines-do-projeto).

#### 3.3.2 Relatórios e Auditorias

As auditorias, que tem como entrada-chave a saída das atividades de Verificação e Validação de software, serão realizadas **sempre antes** da liberação da baseline para o cliente. Tem como objetivo verificar se o que está sendo liberado para o cliente está completo, no que tange as cláusulas contratuais, e atendendo ao requisitos estabelecidos.

Na auditoria é verificado se os componentes estão presentes nas versões especificadas e confirmar a presença de todos os artefatos necessários. Caso, durante a auditoria, alguma falha seja encontrada (Item de Configuração não encontrado), devem ser executados os seguintes passos:

* Identificação do problema, apresentando a discrepância nos artefatos envolvidos.
* Identificar ação corretiva junto aos representantes de cada grupo.
* Se for detectado a ausência de algum artefato, deve ser comunicado ao responsável do artefato para incluí-lo no gerenciamento de configuração.
* Se um artefato não foi feito, ou não está completo, deve ser postergado para uma baseline futura ou negociar para cancelá-lo.
* Se uma *issue* (SM) estiver em aberto, deverá ser analisado qual o melhor encaminhamento, se deverá ser fechada, cancelada ou adiada.

Um *template* para documento de **Auditoria de Configuração (ACS)** está disponível no [Wiki do GitHub](https://github.com/gustavosotnas/Sempre-UFG/wiki) para padronizar as informações necessárias para uma auditoria de configuração bem sucedida.

4. Marcos do projeto
---------
Os principais marcos do projeto são os de último dia de *sprint*, em que há a criação da *baseline* do repositório de controle de versão e a realização das cerimônias de final de *sprint* do *Scrum*. Mais informações no [Plano de Projeto](../Plano de Projeto (Scrum)#54-cronograma-e-marcos).

O Plano de Gerência de Configuração é alterado nos seguintes casos:
* O repositório de versões não está atendendo as necessidades dos integrantes da equipe;
* O Plano não foi aprovado pela ***V&V*** e precisa ser refatorado.

Quando for necessária a refatoração deste Plano, deve ser criada uma nova *issue* de **solicitação de mudança** no Plano de GCS.

5. Treinamento e Recursos
-------------------------
* No [README do repositório principal](https://github.com/gustavosotnas/Sempre-UFG/blob/master/README.md#quick-start) há um guia rápido para utilização do sistema de controle de versão [Git](http://git-scm.com);
* No site do GitHub há um tutorial iterativo para aprender a usar o [Git](http://git-scm.com) em 15 minutos, criado pelo ***Code School***: [https://try.github.io](https://try.github.io/)
* A documentação online do [Git](http://git-scm.com) tem diversos conteúdos a respeito de controle de versão e gerência de configuração de forma completa, mas didática: [http://git-scm.com/doc](http://git-scm.com/doc)
* Nos [guias online do GitHub](https://guides.github.com/) tem um guia rápido para aprendizagem da linguagem de marcação *Markdown*: [https://guides.github.com/features/mastering-markdown/](https://guides.github.com/features/mastering-markdown/)
