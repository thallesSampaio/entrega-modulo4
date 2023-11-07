<h1>Entrega site conectado com banco de dados</h1>
<p>Na url da Rjtrip, pode colocar "/admin" que vai dar acesso a uma tela com 2 tabelas, uma de mensagens e outra de clientes.</p>
<p>Em relação a modelagem do banco de dados, se manteve basicamente a mesma, só foi criado uma nova tabela pra receber as mensagens da página de contato.</p>
<p>CREATE TABLE contatosmsg (<br>
  contato_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,<br>
  nomeContato varchar(100) NOT NULL,<br>
  emailContato varchar(100) NOT NULL,<br>
  telefoneContato varchar(100) NOT NULL,<br>
  mensagemContato varchar(500) UNIQUE NOT NULL
);</p>
<p>Link do video com o site funcionando: https://youtu.be/1y8Hy9xz6n0</p>

<h1>Entrega Java Web</h1>
<p>Mudanças na tabela data viagem, do tipo DATE pra VARCHAR.</p>
<p>Link do video com o site funcionando: https://www.youtube.com/watch?v=b6hRv0wdWO8&ab_channel=Th</p>
