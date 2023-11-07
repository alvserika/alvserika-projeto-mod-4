The Discoverer Experience
Bem-vindo ao repositório do projeto "The Discoverer Experience". Este é um projeto desenvolvido como parte do curso Recode Pro, módulo 04, que abrange os seguintes aspectos:

Banco de Dados
Ajustes no Modelo Lógico do Banco de Dados: Foi realizado um refinamento do modelo lógico do banco de dados, incluindo a definição de tabelas, atributos e relacionamentos. Essas alterações foram feitas para atender às necessidades específicas do projeto.

Implementação do Banco de Dados: O banco de dados foi implementado utilizando o MySQL. Foram criadas as tabelas necessárias de forma manual para armazenar os dados relacionados aos destinos de viagem.

Back-End
Construção do Back-End em Java: O back-end da aplicação foi desenvolvido utilizando tecnologias Java. Foram criadas estruturas de dados e classes para manipulação e gerenciamento das informações.

Padrão de Projeto MVC: A arquitetura da aplicação segue o padrão de projeto MVC (Model-View-Controller), garantindo uma separação clara entre a lógica de negócios (Model), a camada de apresentação (View) e o controle das operações (Controller).

CRUD Básico para Todas as Tabelas: Foi implementado o básico para todas as tabelas do modelo de dados. Isso inclui operações de criação, leitura, atualização e exclusão de informações no banco de dados.

Front-End
Criação de uma Nova Versão do Site: O front-end da aplicação foi atualizado para criar uma nova versão do site. Isso inclui a implementação de páginas e interfaces de usuário aprimoradas.

Padrão de Projeto MVC no Front-End: A camada de apresentação no front-end também segue o padrão de projeto MVC. Isso significa que as telas de cadastro estão conectadas ao banco de dados através da lógica de controle (Controller) e a representação visual (View) foi projetada para melhorar a experiência do usuário.

O "The Discoverer Experience" é um projeto ambicioso que combina a gestão de dados, o desenvolvimento de back-end e a criação de interfaces de usuário intuitivas para fornecer uma experiência de viagem única aos usuários. Este repositório contém todo o código e recursos necessários para executar o projeto e continuar seu desenvolvimento.

Estrutura de Pastas
A estrutura de pastas do projeto está organizada da seguinte forma:

css
Copy code
projeto-mod-4/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── connection/
│   │   │   ├── controller/
│   │   │   ├── dao/
│   │   │   ├── model/
│   │   │   ├── ...
│   │   ├── webapp/
│   │   │   ├── html/
│   │   │   ├── styles/
│   │   │   ├── js/
│   │   │   ├── assets/
│   │   │   ├── components/
│   │   │   ├── constants/
│   │   │   ├── ...
├── build/
│   ├── classes/
│   │   ├── connection/
│   │   ├── controller/
│   │   ├── dao/
│   │   ├── model/
│   │   ├── ...
├── .gitignore
├── README.md
Pré-requisitos
Antes de começar a trabalhar com o projeto, certifique-se de ter instalado as seguintes ferramentas e tecnologias:

Tomcat - Um servidor web utilizado para executar aplicativos Java EE.
Java EE - Uma plataforma para desenvolvimento de aplicações empresariais baseadas em Java.
Eclipse - Um ambiente de desenvolvimento integrado (IDE) amplamente utilizado para desenvolver aplicativos Java EE.
MySQL - Um sistema de gerenciamento de banco de dados relacional utilizado para armazenar os dados do projeto.
Configuração
Siga estas etapas para configurar o projeto em sua máquina local:

Clone este repositório:
bash
Copy code
git clone https://github.com/alvserika/projeto-mod-4.git
Abra o Eclipse e importe o projeto:

No Eclipse, vá para "File" -> "Import...".
Selecione "General" -> "Projects from Folder or Archive" e clique em "Next".
Selecione a pasta do projeto clonado e clique em "Finish".
Configure o servidor Tomcat no Eclipse:

No Eclipse, vá para "Window" -> "Preferences".
Na janela de preferências, expanda "Server" e selecione "Runtime Environments".
Adicione uma nova instância do servidor Tomcat, apontando para a pasta de instalação do Tomcat em sua máquina.
Inicie o servidor Tomcat no Eclipse:

No Eclipse, vá para a aba "Servers" na parte inferior.
Clique com o botão direito e selecione "New" -> "Server".
Selecione o servidor Tomcat configurado anteriormente e clique em "Finish".
Inicie o servidor a partir desta aba.
Agora, o projeto estará configurado localmente e poderá ser executado no servidor Tomcat.

Uso
Depois de configurar o projeto e iniciar o servidor Tomcat, você pode acessar a aplicação a partir de um navegador da web. Normalmente, a aplicação pode ser acessada em http://localhost:8080/projeto-mod-4.

Contribuindo
Se você deseja contribuir para o desenvolvimento deste projeto, siga as etapas abaixo:

Faça um fork deste repositório.

Crie uma branch para a sua feature:

bash
Copy code
git checkout -b minha-feature
Faça commit das suas alterações:
bash
Copy code
git commit -m 'Adicionar minha feature'
Faça push da branch:
bash
Copy code
git push origin minha-feature
Abra um pull request.
 
