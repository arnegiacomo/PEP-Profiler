# Stacc code challenge 2021
https://github.com/stacc/stacc-code-challenge-public


## Oppgavebeskrivelse
PEP-Profiler er en desktop basert Java-applikasjon som lar brukeren utføre [PEP](https://en.wikipedia.org/wiki/Politically_exposed_person)-sjekk gjennom [OpenSanctions](https://www.opensanctions.org/docs/api/)
sitt API, og henter deretter relevant Wikipedia-info (bilde og "summary") om personen gjennom [OpenSearch](https://www.mediawiki.org/wiki/API:Opensearch)
API-et. Applikasjonen benytter et GUI som lar brukeren søke etter nøkkelverdier som navn, og blir deretter presentert med en liste med
mulige treff. Deretter kan brukeren trykke på treffene og finne ut mer om denne personen. Målet er at applikasjonen skal
være et verktøy som gjør PEP-sjekker mer informative og mer tilgjengelige.

## Hvordan kjøre prosjektet
- Fylle ut senere

## Kommentarer
Jeg er noe misfornøyd med løsningen min, men jeg synes den har noe nyttig bruksområde. Om jeg hadde hatt mer tid så ville jeg
nok laget en webapp... Men forsåvidt er jeg fornøyd med mengden funksjonalitet jeg fikk lagt inn på 3 dager.

- - -
 ### Forslag til forbedring
- Webbasert løsning: Dette gjør applikasjonen mer tilgjengelig, men grunnet mangel på tid, så valgte jeg å lage en desktop applikasjon istedet, i og med at en desktop app er enklere å få "up and running".
- Caching av data: API-spørringene er treige, spesielt når man gjør mange av dem, man kunne cachet mye av denne dataen enten lokalt eller i en database, dette kombinerer seg også veldig godt med en webbasert løsning.
- Finere GUI: GUI er vanskelig i java, hvis dette hadde vært en webapp kunne man lettere benyttet seg av GUI-rammeverk, som kan gjøre applikasjonen lettere å bruke, og mer responsiv.
- Ekspandert funksjonalitet: Kanskje man kunne søkt på flere typer verdier, sortert resultater eller hentet relevant informasjon fra flere kilder.
- Support for flere språk: Dette er nok en ganske stor oppgave, men hadde vært kult!