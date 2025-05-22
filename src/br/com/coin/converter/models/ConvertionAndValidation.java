package br.com.coin.converter.models;

public class ConvertionAndValidation {
    public String convertAndValidate(int option, String base, String convert, double value) {
        ApiSearch search = new ApiSearch();
        String text = "";
        switch (option) {
            case 1:
                base = "USD";
                convert = "ARS";
                break;
            case 2:
                base = "ARS";
                convert = "USD";
                break;
            case 3:
                base = "USD";
                convert = "BRL";
                break;
            case 4:
                base = "BRL";
                convert = "USD";
                break;
            case 5:
                base = "USD";
                convert = "COP";
                break;
            case 6:
                base = "COP";
                convert = "USD";
                break;
            case 7:
                base = "JPY";
                convert = "BRL";
                break;
            case 8:
                base = "BRL";
                convert = "JPY";
                break;
            case 9:
                base = "KRW";
                convert = "BRL";
                break;
            case 10:
                base = "BRL";
                convert = "KRW";
                break;
            default:
                text = "Opção inválida!";
                option = 12;
                break;
        }
        if (option != 12) {
            var result = search.getCoinInfo(base);
            var covertionResult = result.convertion(value, convert);
            text = "Valor " + String.format("%.1f", value) + " [" + base + "] "  + "corresponde ao valor final de =>>> "
                    + covertionResult + " [" + convert + "] ";
        }
        return text;
    }

    public String baseMessage() {
        return """
                ************************************************
                Seja bem-vindo/a ao Conversor de Moeda =]
                
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
                11) Ver operações já realizadas.
                12) Sair
                
                Escolha uma opção válida:
                ************************************************
                """;
    }
}
