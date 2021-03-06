package pl.parser.nbp.domain;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "tabela_kursow")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CurrencyExchangeTable {

    @XmlElement(name="data_publikacji")
    @XmlSchemaType(name="date")
    private Date publicationDate;
    @XmlElement(name = "pozycja")
    private List<Position> positions;
}
