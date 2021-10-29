# SK.Specification

Specifikacija predstavlja način integracije implementacionih komponenti sa izvršnom, Core komponentom.

Implementacione komponente su dužne da implementiraju `IODriver` interfejs, koji predstavlja drajver za interakciju sa okruženjem (operativnim sistemom.)

Za učitavanje fajlova/direktorijuma, drajveri su dužni da koriste strukturu `DirectoryBuilder` i `FileBuilder`, koji suštinski predstavljaju "placeholder" komponente za građenje strukture direktorijuma.