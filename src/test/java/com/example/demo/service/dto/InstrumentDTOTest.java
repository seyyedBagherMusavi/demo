package com.example.demo.service.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InstrumentDTOTest {

    @Test
    void dtoEqualsVerifier(){
        InstrumentDTO instrumentDTO1 = new InstrumentDTO();
        instrumentDTO1.setId(1L);
        InstrumentDTO instrumentDTO2 = new InstrumentDTO();
        assertThat(instrumentDTO1).isNotEqualTo(instrumentDTO2);
        instrumentDTO2.setId(instrumentDTO1.getId());
        assertThat(instrumentDTO1).isEqualTo(instrumentDTO2);
        instrumentDTO2.setId(2L);
        assertThat(instrumentDTO1).isNotEqualTo(instrumentDTO2);
        instrumentDTO1.setId(null);
        assertThat(instrumentDTO1).isNotEqualTo(instrumentDTO2);
    }
}
