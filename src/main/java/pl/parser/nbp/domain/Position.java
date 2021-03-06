package pl.parser.nbp.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pozycja")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Position {

    @XmlElement(name = "nazwa_waluty")
    private String currencyName;
    @XmlElement(name = "przelicznik")
    private Integer conversionFactor;
    @XmlElement(name = "kod_waluty")
    private String currencyCode;
    @XmlElement(name = "kurs_kupna")
    private String purchasePrice;
    @XmlElement(name = "kurs_sprzedazy")
    private String sellingRate;
}
