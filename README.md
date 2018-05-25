# ListToMe

## Description

Implementation of final project to the discipline of Programming II belonging the Federal University of Campina Grande, in the semester of 2018.1.

## Specification 

Lista pra mim© 

O Lista pra mim©, é um app que vai revolucionar a forma como você faz compras. Quanto mais você usar o Lista pra mim, mais rápido vai ser gerar novas listas de compras. E você ainda pode economizar anotando preços e locais de compra. Depois é só deixar o Lista pra mim© indicar o melhor lugar para você fazer suas compras.

Requisitos importantes a serem considerados:
Caso de uso 1: CRUD dos itens compráveis
Caso de uso 2: outras funcionalidades de pesquisa de itens
Caso de uso 3: CRUD de listas de compra
Caso de uso 4: Pesquisar listas de compras
Caso de uso 5: Geração automática de listas de compras
Caso de uso 6: Sugestão do melhor estabelecimento para as compras
Caso de uso 7: Persistência

Requisitos importantes a serem considerados:
É importante ter em mente que ao desenvolver um programa, uma série de decisões importantes de design são tomadas. Uma ótima prática de programação é sempre separar a interface gráfica das classes do domínio do problema. Isso é importante para garantir que mudanças na interface não irão necessitar mudanças nas classes do domínio do problema e mudanças nas classes do domínio do problema não irão requerer mudanças na interface gráfica. Dessa forma, essas partes conceituais do programa ficam isoladas. Nesse projeto iremos alcançar esse isolamento usando uma classe de fachada (ou facade) e classes controladoras (ou controllers). Veja mais detalhes a seguir:

Todas as suas classes que fazem parte do domínio do problema não devem ser acessadas diretamente pelo código da interface gráfica. Portanto, você deve usar o padrão de projeto facade. Para saber mais sobre esse padrão de projeto você pode estudar um pouco aqui ou aqui (ou em outro material que ache legal). Essa classe de fachada vai fazer a comunicação entre a interface gráfica que seu colega irá desenvolver e as classes do domínio do problema que seu grupo irá desenvolver.
A sua classe de fachada também não deve entender muito das classes do domínio do problema. O ideal é que cada método dessa classe tenha apenas uma linha de código, que será uma chamada por delegação a um método de algum controller. Assim, você terá que usar classes controladoras (controllers) para esconder da fachada tratamentos de entradas que a fachada não deveria ter responsabilidade de fazer, mas que você também não quer delegar para uma classe do domínio do problema. Por exemplo, quando um usuário vai adicionar um item de sua coleção de itens a emprestar, ele irá informar o nome do item, o valor, e quaisquer outras informações para que esse item seja criado. Em vez de chamar diretamente o objeto usuário onde o item deve ser inserido, você deve chamar um controlador que vai checar se essa entrada é válida e só então chama o objeto necessário para a operação. O uso de controladores é mais um nível de abstração para separar a interface gráfica das classes do domínio do problema. Esse controlador faz parte de um padrão de projeto muito usado chamado model-view-controller. Você pode entender um pouco mais desse padrão aqui ou aqui.

Você verá que a classe de fachada e os controladores serão escritos aos poucos ao longo do projeto à medida que o grupo avança no desenvolvimento dos casos de uso. Assim, não teremos casos de uso específicos para o desenvolvimento destas entidades, mas lembre-se que a cada caso de uso vocês devem considerar a classe de fachada e os controladores necessários para lidar com o caso de uso sendo desenvolvido.

Caso de uso 1: CRUD dos itens compráveis

Deve ser possível fazer CRUD (Create, read, update and delete) de itens compráveis no Lista pra mim©. Todo item comprável deve manter as seguintes informações obrigatoriamente: identificador único numérico, nome, categoria e mapa de preços. O identificador numérico deve ser gerado automaticamente pelo sistema. Não deve ser permitido que itens iguais sejam adicionados no sistema. Dois itens compráveis são iguais se eles tem o mesmo nome e categoria. As categorias contempladas no Lista pra mim© são: alimentos industrializados, alimentos não industrializados, limpeza e higiene pessoal.

Os itens compráveis podem ser de três tipos:
Produtos com quantidade fixa (por exemplo, frasco de detergente Brilhol com 500ml, ou saco de algodão Clemer com 300g, ou caixa com 18 ovos). Esses itens devem manter a quantidade e a medida do produto. No exemplo do detergente a quantidade é 500 e a medida é mililitro, já para o algodão a quantidade é 300 e a medida grama. Já no caso do ovo a quantidade é 18 e a medida é "unidade do produto";
Produtos não industrializados por quilo. Em geral são os produtos de açougue e hortifruti;
Produto por unidade, como pacote de biscoito recheado Vox, ou copo de requeijão cremoso fofonlí, ou ainda abacaxi. A maioria dos produtos de higiene pessoal e alimentos industrializados recai nessa classe de itens. 

O mapa de preços existe para todo item comprável e vai sendo atualizado cada vez que o usuário compra um item em um estabelecimento e obtém o preço do produto. Neste mapa são acumulados os preços para diferentes estabelecimentos de compra. Para os produtos com quantidade fixa, o preço será o preço total da quantidade fixa estabelecida, por exemplo, o preço do pacote de algodão de 300 gramas. Para os produtos por unidade, o preço é pela unidade, por exemplo, o preço de uma unidade de abacaxi ou de uma unidade de pacote de biscoito Vox. Já para os itens não industrializados por quilo, o preço definido deve ser por quilo. Deve ser possível ter uma representação de String de um item comprável das seguintes formas:
Se for produto com quantidade fixa: 219. Algodão Clemer, higiene pessoal, 300 gramas, Preço: <Supermercado BaratoD+, R$ 2,33;  Baratão, R$ 2,30>
Se for produto não industrializado por quilo: 34. Chuchu, alimentos não industrializados, Preço por quilo: <Supermercado BaratoD+, R$ 1,34;  Baratão, R$ 1,30>
Se for um produto por unidade: 87. Queijo minas Dali, alimentos industrializados, Preço: <Baratão, R$ 4,30>

Adicionar/remover/pesquisar/atualizar um item no Lista pra mim©  significa adicionar/remover/pesquisar/atualizar um item na coleção de itens daquela instalação do app. Não existe um usuário específico, todos os usuários que acessam o app pelo mesmo celular irá ver a mesma coleção de itens compráveis. A pesquisa de itens oferecida pelo sistema deve usar o seu identificador e portanto pode retornar apenas um  item. Todos os atributos de itens compráveis podem ser atualizados, exceto o seu identificador único. 

Implemente a parte da classe de fachada e o(s) controlador(es) necessários para lidar com as classes/funcionalidades criadas neste caso de uso. Para avaliar melhor o desenvolvimento deste caso de uso rode esses testes de aceitação com EasyAccept. 
Caso de uso 2: outras funcionalidades de pesquisa de itens

Uma vez que o sistema já conhece os itens compráveis, chegou a hora de escrever algumas funcionalidades interessantes.

O sistema deve permitir uma listagem de todos os itens cadastrados no sistema, ordenada em ordem alfabética pela representação em string do item;
O sistema deve permitir uma listagem de todos os itens cadastrados no sistema de uma dada categoria, ordenada em ordem alfabética pela representação em string do item;
O sistema deve permitir uma listagem de todos os itens inseridos no sistema ordenada em ordem crescente do menor preço cadastrado para os itens. Nesta pesquisa apenas os itens que tiverem pelo menos um preço cadastrado aparecem;
O sistema deve listar todos os itens relacionados a uma dada string de pesquisa. Se por exemplo, o usuário digitar algodão, então todos os itens cujo nome contém a string "algodão" devem ser listados. Essa pesquisa não deve ser sensível a maiúscula/minúscula, assim, se a pesquisa foi da string "algodão", mas no nome do item está armazenado "Algodão", esse item deve ser selecionado na pesquisa. Essa listagem deve ocorrer em ordem alfabética considerando a representação em string do item.

Implemente a parte da classe de fachada e o(s) controlador(es) necessários para lidar com as classes/funcionalidades criadas neste caso de uso.  Testes de aceitação disponíveis aqui.

Caso de uso 3: CRUD de listas de compra
O app deve permitir a criação de listas de compra. Uma lista de compras é caracterizada por um descritor e uma coleção de itens a comprar, ou compras. A lista de compras também insere automaticamente um atributo que identifica a data/hora em que a lista de compras foi criada. O descritor deve descrever a compra, por exemplo, "feira 23/05/2018". Cada compra deve indicar a quantidade e o item comprável. Quando o item comprável for um produto industrializados por quilo, é possível que a quantidade a ser comprada seja um valor não inteiro. O identificador único do item comprável deve ser usado para indicar o item de interesse. Para os outros tipos de itens apenas valores inteiros são aceitos.  Deve ser possível adicionar, remover e atualizar as compras de uma lista de compras. A atualização deve ocorrer apenas na quantidade a ser comprada e não do item comprável em si. Quando uma atualização modificar a quantidade de um item comprável para zero, então este item deve ser removido da lista.  Uma compra de uma lista de compras pode ser pesquisada usando o identificador do item a ser comprado. Cada item comprável só pode aparecer uma vez em cada lista de compra, assim não deve ser possível inserir mais de uma compra para o mesmo item em uma lista de compras. 

O Lista pra mim© não permite que descritores de listas de compras sejam repetidos. Se já existir no sistema uma lista com o descritor "feira 23/05/2017" então nenhuma outra lista de compra pode ter o mesmo descritor.

Deve ser possível imprimir uma lista de compras como a seguir:

1 Algodão Clemer, higiene pessoal, 300 gramas
2 Pasta dental DDS, higiene pessoal, 120 gramas
5 Sabonete de aveia Dorene, higiene pessoal, 80 gramas
2 Sabão líquido Pomo, limpeza, 1 litro
1 Creme de ricota Rocotó, alimentos industrializados
2 Iogurte Lactivia, alimentos industrializado
1 Queijo minas Dali, alimentos industrializado
0,5 kg Chuchu, alimentos não industrializados
1,5 kg Tomate, alimentos não industrializados
2,0 kg Carne moída extra light, alimentos não industrializados

Note que a lista está ordenada em 2 níveis. Em um primeiro nível está ordenada pela categoria do tipo do item na ordem default: higiene pessoal, limpeza, alimentos industrializados e alimentos não industrializados. Dentro de cada categoria os itens são ordenados pelo nome em ordem crescente.

Finalmente, uma vez realizadas as compras da lista, o usuário deve finalizar essa lista e registrar na lista o local onde a compra foi realizada e o valor final da compra. Então além das informações já mencionadas anteriormente que devem ser armazenadas em uma lista de compras, essas duas novas informações devem ser adicionadas.

Caso de uso 4: Pesquisar listas de compras
Listas de compras inseridas no  Lista pra mim© podem ser pesquisadas da seguinte forma:
Usando o descritor da lista. Neste caso, apenas uma lista de compras deve ser retornada, já que o  Lista pra mim© não aceita descritores repetidos. Uma representação em String da lista de compras deve ser retornada, seguindo a mesma ordenação de impressão da lista de compras;
Usando uma data. Neste caso o  Lista pra mim© deve retornar todos os descritores as listas de compras criadas na data específica. Esta pesquisa deve retornar uma String com todos os descritores das listas de compras criadas na data especificada, ordenados em ordem lexicográfica crescente dos descritores. Exemplo:
		Compras extra atacadão
		Feira de 23/05/2018
		Produtos naturais
Usando o código de um item comprável. Esta pesquisa deve retornar os descritores de todas as listas de compras que contemplam o item especificado, ordenadas pela data de criação das listas. As datas de criação também devem ser retornadas na String de resposta. Exemplo:
		02/05/2018 - Compras atacadão
		15/05/2018 - Compras de mês
		23/05/2018 - Limpeza 25/05/2018
(No caso em que várias listas forem criadas na mesma data, seus descritores devem ser ordenados em ordem lexicográfica crescente).
Caso de uso 5: Geração automática de listas de compras
O Lista pra mim© deve ser capaz de gerar listas de compras para a comodidade de seus usuários. Não é indicado que uma lista de compras já finalizadas seja modificada, pois no futuro os desenvolvedores do Lista pra mim© pretendem gerar relatórios da história das compras, estatísticas de preço, etc. A geração de listas de compras automática segue estratégias diferentes:
Estratégia 1: essa estratégia apenas repete a lista de compras mais recentemente criada. O descritor dessa nova lista de compras é "Lista automática 1 dd/mm/aaaa". Essa data corresponde à data na qual essa lista automática está sendo gerada. Esta lista de compras inicia sem um preço final e não finalizada;
Estratégia 2: nessa estratégia uma lista de compras é gerada usando como base um item de compra específico que deve ser especificado pelo usuário. O Lista pra mim© deve encontrar a última lista de compras que contempla o item de compra indicado pelo usuário. O descritor dessa nova lista de compras é "Lista automática 2 dd/mm/aaaa". Essa data corresponde à data na qual essa lista automática está sendo gerada. Esta lista de compras inicia sem um preço final e não finalizada;
Estratégia 3: A última estratégia gera uma lista de compras com os itens de compras que mais aparecem nas listas de compras anteriores. Para que um item de compras entre nessa lista ele tem que ter aparecido em pelo menos metade das listas de compras já inseridas no app. O descritor dessa nova lista de compras é "Lista automática 3 dd/mm/aaaa". Essa data corresponde à data na qual essa lista automática está sendo gerada. Esta lista de compras inicia sem um preço final e não finalizada.
Caso de uso 6: Sugestão do melhor estabelecimento para as compras
Com base nos preços cadastrados nos itens de compra, o Lista pra mim© deve ser capaz de indicar o estabelecimento que vai resultar no menor preço para uma determinada lista de compras. É possível que não exista informação de preço para todos os produtos em todos os estabelecimentos de compra. Isso não deve impedir que o app sugira um estabelecimento. A sugestão dada deve levar em conta apenas os preços dos produtos cadastrados para os estabelecimentos de forma comparativa, assim, apenas os itens com preços em todos os estabelecimentos devem ser considerados para essa decisão. Vejamos um exemplo:

1 Algodão Clemer, higiene pessoal, 300 gramas
2 Sabão líquido Pomo, limpeza, 1 litro
1 Queijo minas Dali, alimentos industrializado
0,5 kg Chuchu, alimentos não industrializados
2,0 kg Carne moída extra light, alimentos não industrializados

Considerando as informações que temos para estes itens de compra (ver abaixo), percebemos que os dois estabelecimentos mais mencionados são BaratoD+ e Baratão. Nesse caso, o software que sugere o melhor lugar para realizar as compras deve indicar os itens que registraram preços para BaratoD+ e Baratão.

219. Algodão Clemer, higiene pessoal, 300 gramas, Preço: <Supermercado BaratoD+, R$ 2,33;  Baratão, R$ 2,30>
102. Sabão líquido Pomo, limpeza, 1 litro, Preço: <Supermercado BaratoD+, R$ 12,89;  Baratão, R$ 12,30>
34. Chuchu, alimentos não industrializados, Preço por quilo: <Supermercado BaratoD+, R$ 1,34;  Baratão, R$ 1,30>
87. Queijo minas Dali, alimentos industrializados, Preço: <Baratão, R$ 4,30>
201. Carne moída extra light, alimentos não industrializados, Preço por quilo: <Supermercado BaratoD+, R$ 42,34;  Baratão, R$ 41,30>

Neste exemplo, não é possível comparar o preço dessas compras incluindo o queijo minas, já que para este queijo só há registro de preço para o supermercado Baratão. Esta funcionalidade deve indicar os dois estabelecimentos mais indicados para estas compras e o preço parcial das compras em cada um, apresentando primeiro quem tem o menor preço parcial:

Baratão, R$ 113,46
BaratoD+, R$ 110,15

Com base nesses itens o Baratão deve ser o melhor lugar para fazer essas compras. No caso em que os locais de compra mais registrados não tenham itens em comum, essa funcionalidade deve indicar esse problema.

Faltam dados para identificar se o melhor local de compra e o Baratão ou o BaratoD+
Caso de uso 7: Persistência

O Lista pra mim©  deve armazenar em disco todos os dados necessários para manter o seu estado mesmo que o programa seja fechado. Assim, se eu usar o programa, adicionar listas de compras e itens de compra, gerar novas listas automaticamente, modificar as listas, etc. tudo isso deve ser visto se eu fechar o programa e abrir novamente.

Implemente a parte da classe de fachada e o(s) controlador(es) necessários para lidar com as classes/funcionalidades criadas neste caso de uso. Testes de aceitação disponíveis aqui.

https://docs.google.com/document/d/1va1oi8okdXPczsvkVFdkPlCAF0wtYRSi-dXtT-xAGeI/edit?ts=5b0803a3
