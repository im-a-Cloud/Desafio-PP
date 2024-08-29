package com.DesafioPP.DTOS;

import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal valorTransferencia, Long idRemetente, Long idDestinatario) {
}
