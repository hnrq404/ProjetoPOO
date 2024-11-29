# Sistemas integrados: Gestão de Eventos, Clínica Médica e Gerenciamento de Restaurante 

Nesta etapa do projeto amplíamos o desenvolvimento dos três sistemas, utilizando Herança, Polimorfismo, Sobrecarga de Métodos, além da implementação de Interfaces usando classes abstratas. <br>
Afim de uma melhor organização dos nossos sistemas, utilizamos os príncipios SOLID, além de diagramas UML. Segue abaixo: <br>
# Princípios SOLID: <br>
- Clínica Médica:<br>
1. Princípio da Responsabilidade Única (SRP): <br>
A classe Medico é responsável apenas por atributos e comportamentos comuns a todos os médicos, enquanto a interface Agendavel lida apenas com agendamentos. <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_1.png"> <br>
2. Princípio Aberto/Fechado (OCP): <br>
A classe Medico é aberta para extensão, pois permite criar novos tipos de médicos (MedicoCardiologista, MedicoPediatra) sem modificar o código da classe base. <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_2.png"> <br>
3. Princípio da Substituição de Liskov (LSP): <br>
Substituir a classe base Medico por qualquer subclasse (MedicoCardiologista, MedicoPediatra) mantém o comportamento esperado. <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_3.png"> <br>
4. Princípio da Segregação de Interfaces (ISP): <br>
A interface Agendavel foi criada para que apenas as funcionalidades de agendamento sejam implementadas, sem forçar métodos desnecessários na classe Medico. <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_4.png"> <br>
5. Princípio da Inversão de Dependência (DIP): <br>
A classe principal (ou consumidor) depende da abstração Agendavel, e não de implementações concretas como MedicoCardiologista. <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_5.png"> <br>
- Sistema de Eventos: <br>
1. Princípio da Responsabilidade Única (SRP): <br>
A classe Evento gerencia informações gerais dos eventos, enquanto a interface Organizavel lida com a organização (cronogramas e palestrantes). <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_6.png"> <br>
2. Princípio Aberto/Fechado (OCP): <br>
A classe Evento pode ser estendida por novos tipos de eventos (Workshop, Seminario) sem precisar alterar seu código. <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_7.png"> <br>
3. Princípio da Substituição de Liskov (LSP): <br>
Substituir a classe base Evento por qualquer subclasse (Workshop, Seminario) funciona corretamente. <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_8.png"> <br>
4.Princípio da Segregação de Interfaces (ISP): <br>
A interface Organizavel contém apenas métodos relevantes à organização, e não força subclasses de Evento a implementar métodos desnecessários.<br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_9.png"> <br>
5.Princípio da Inversão de Dependência (DIP): <br>
O sistema pode usar a interface Organizavel para trabalhar com eventos organizáveis, sem depender de classes concretas. <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_10.png"> <br>

- Sistema de Restaurante: <br>
1. Princípio da Responsabilidade Única (SRP): <br>
A classe Menu é responsável por atributos e métodos comuns a itens do menu, enquanto a interface Personalizavel é responsável por customizações. <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_11.png"> <br>
2. Princípio Aberto/Fechado (OCP):
Novos tipos de itens, como Sobremesa, podem ser criados estendendo a classe Menu. <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_12.png"> <br>
3. Princípio da Substituição de Liskov (LSP): <br>
Substituir a classe base Menu por subclasses (PratoPrincipal, Bebida) mantém o comportamento esperado. <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_13.png"> <br>
4. Princípio da Segregação de Interfaces (ISP): <br>
A interface Personalizavel é implementada apenas por itens que precisam de personalização. <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_14.png"> <br>
5. Princípio da Inversão de Dependência (DIP): <br>
Funções que dependem da interface Personalizavel podem ser usadas com qualquer item que implemente essa interface. <br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/assets/Screenshot_15.png"> <br>

#Diagramas UML: <br>

<h3>DIAGRAMA DE FLUXO - (AGENDAMENTO MÉDICO)</h3><br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/UML_Sistemas-AGENDAMENTO-CONSULTA.drawio.png" alt="img-agendamento_medico">
<h3>UML CLINICA MÉDICA</h3></h3><br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/UML_Sistemas-UML-EVENTO.drawio.png" alt="img-agendamento_medico">
<h3>UML RESTAURANTE</h3><br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/UML_Sistemas-UML-RESTAURANTE.drawio.png" alt="img-agendamento_medico">
<h3>UML EVENTOS</h3><br>
<img src="https://github.com/hnrq404/ProjetoPOO/blob/main/UML_Sistemas-UML-EVENTO.drawio.png" alt="img-agendamento_medico">
