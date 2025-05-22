# Conversor de Moedas via Terminal

Este é um simples conversor de moedas que realiza as operações diretamente no terminal. Ele utiliza a API [ExchangeRate-API](https://www.exchangerate-api.com/) para obter as taxas de câmbio mais recentes.

## Funcionalidades

O conversor oferece as seguintes operações:
###

      1) Dólar =>> Peso argentino
      2) Peso argentino =>> Dólar
      3) Dólar =>> Real brasileiro
      4) Real brasileiro =>> Dólar
      5) Dólar =>> Peso colombiano
      6) Peso colombiano =>> Dólar
      7) Yen japonês =>> Real brasileiro
      8) Real brasileiro =>> Yen japonês
      9) Won sul coreano =>> Real brasileiro
      10) Real brasileiro =>> Won sul coreano

###

Além disso, o sistema mantém um histórico das operações realizadas, que pode ser visualizado através da opção `11`.

## Tecnologias Utilizadas

* Java
* Gson (para manipulação de JSON)
* HttpClient (para fazer requisições HTTP)
* [ExchangeRate-API](https://www.exchangerate-api.com/)

## Como Utilizar

1.  **Clone o repositório do projeto (se aplicável).**
2.  **Adicione sua chave da API:** Para que o projeto funcione corretamente, é necessário obter uma chave de API gratuita no site da [ExchangeRate-API](https://app.exchangerate-api.com/sign-up). Após obter a chave, você deve adicioná-la na variável `apiKey` dentro da função `getCoinInfo` na classe `ApiSearch`.

    ```java
    public Coin getCoinInfo(String base) {
        try {
            String apiKey = "SUA_CHAVE_DA_API_AQUI";
            // ... restante do código ...
        } catch (RuntimeException | IOException | InterruptedException error) {
            System.out.println(error.getMessage());
            throw new RuntimeException(error);
        }
    }
    ```

3.  **Compile o projeto Java.** Você pode fazer isso utilizando um ambiente de desenvolvimento integrado (IDE) como IntelliJ IDEA, Eclipse, ou através da linha de comando com o compilador `javac`.

    ```bash
    javac src/*.java
    ```

4.  **Execute o projeto.**

    ```bash
    java src/Main
    ```

    *(Assumindo que sua classe principal se chama `Main` e está dentro do diretório `src`)*

5.  Siga as instruções no terminal para realizar as conversões desejadas.

## Estrutura do Projeto

A solução implementa as seguintes classes principais:

* `Main`: Contém a função `main` para iniciar a aplicação e interagir com o usuário no terminal.
* `ConvertionAndValidation`: Possui a lógica para apresentar a mensagem base de opções (`baseMessage`) e realizar a conversão de moedas (`convertAndValidate`), utilizando a `ApiSearch`.
* `ApiSearch`: Responsável por fazer a chamada à API do ExchangeRate-API para obter as taxas de câmbio através da função `getCoinInfo`.
* `Coin`: Representa as informações da taxa de câmbio retornadas pela API e contém a lógica para realizar a conversão (`convertion`).
* `ExchangeRateObj`: Classe utilizada para desserializar o JSON retornado pela API.
* `Operation`: Representa uma operação de conversão realizada, armazenando o momento da operação e a descrição da conversão.

## Histórico de Operações

O sistema mantém um registro das conversões efetuadas. Ao selecionar a opção `11`, é exibida uma lista das operações já realizadas, formatadas da seguinte maneira:

      Operação realizada em: [data e hora da operação]
      Tipo: [resultado da conversão]

## Observação

Lembre-se de substituir `"SUA_CHAVE_DA_API_AQUI"` pela sua chave da API no arquivo `ApiSearch.java` para que o conversor funcione corretamente.

Aproveite o conversor de moedas!