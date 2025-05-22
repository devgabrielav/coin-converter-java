package br.com.coin.converter.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operation {
    String operationTime;
    String operationDone;

    public Operation(String operationDone) {
        var currentTime = LocalDateTime.now();
        DateTimeFormatter formatterSaida = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");

        this.operationTime = currentTime.format(formatterSaida);
        this.operationDone = operationDone;
    }

    @Override
    public String toString() {
        return String.format("""
                
                Operação realizada em: %s
                Tipo: %s
                """, this.operationTime, this.operationDone);
    }
}
