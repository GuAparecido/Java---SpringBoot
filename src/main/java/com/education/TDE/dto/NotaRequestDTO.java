package com.education.TDE.dto;

import java.time.LocalDate;
import java.util.Date;

public record NotaRequestDTO(Double nota, LocalDate data_lancamento) {
}
