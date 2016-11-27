# RNF-ContrAcesPapel: Recursos com controle de acesso baseado em papel podem ser configurados.

Para o projeto deste requisito, faz-se necessário mapear:
 * Os tipos de papéis que o sistema trará;
 * As funções que o sistema oferecerá e
 * O nível de permissão que cada papel tem em cada função por padrão.

Tendo isso em mente, temos por papéis do sistema:
 - Gestor do Sistema (Administrador)
 - Visitante
 - Egresso
 - PROGRAD
 - CAVI
 - PRPG

As funções oferecidas pelo sistema são:
 1. Cadastro / Inclusão
    1.1 Egresso
    1.2 Notícia
    1.3 Evento
 2. Visualização / Consulta
    2.1 Egresso
    2.2 Notícia
    2.3 Evento
 3. Edição / Exclusão
    3.1 Egresso
    3.2 Notícia
    3.3 Evento
 4. Privilégios Adminsitrativos
    4.1 Manter Papéis
    4.2 Manter Usuários
    4.3 Manter Avisos do Sistema

Por padrão, cada perfil tem o seguinte mapeamento de permissões:

|                   | 1 | 2 | 3 | 4 |
|-------------------|---|---|---|---|
| Gestor do Sistema | X | X | X | X |
| Visitante         |   | X |   |   |
| Egresso           |   | X | X |   |
| PROGRAD           | X | X | X |   |
| CAVI              | X | X | X |   |
| PRPG              | X | X | X |   |

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O controle e gerenciamento manual dos papéis será feito por uma tela do sistema, chamada "papéis". Essa tela pode ser acessada apenas pelo gestor do sistema (ou administrador) pois somente ele tem o poder para exercer tais alterações.
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nesta tela, primeiro seleciona-se o papel para o qual se deseja realizar modificações de permissão e logo em seguida uma janela com as permissões atuais desse papel é exibida. A partir de então será possível ligar/desligar as opções de permissão para o papel escolhido e ao salvar, as novas seleções serão persistidas e aplicadas para o grupo de usuários que tem aquele papel.