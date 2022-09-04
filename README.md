# Stacc code challenge 2022
https://github.com/stacc/stacc-code-challenge-public


## Oppgavebeskrivelse
PEP-Profiler er en desktop basert Java-applikasjon som lar brukeren utføre [PEP](https://en.wikipedia.org/wiki/Politically_exposed_person)-sjekk gjennom [OpenSanctions](https://www.opensanctions.org/docs/api/)
sitt API, og henter deretter relevant Wikipedia-info (bilde og "summary") om personen gjennom [OpenSearch](https://www.mediawiki.org/wiki/API:Opensearch)
API-et. Applikasjonen benytter et GUI som lar brukeren søke etter nøkkelverdier som navn, nasjonalitet og mye mye mer, og blir deretter presentert med en liste med
mulige treff. Deretter kan brukeren trykke på treffene og finne ut mer om personen de trykket på. I tillegg kan man lagre og laste inn PEP-profiler, disse lagres lokalt i en fil og kan lastes inn når som helst, eller fjernes fra cache om man ønsker det. Målet er at applikasjonen skal
være et verktøy som gjør PEP-sjekker mer informative og mer tilgjengelige/brukervennlige. 

## Hvordan kjøre prosjektet
```
Kjøre som applikasjon (JDK 17.0.2):
  (NB! Hvis man kjører denne på mac så må man kjøre gjennom Terminal)
  1. Last ned Release 1.0 (til høyre), og pakk ut zip filen hvor som helst
  2. Dobbeltklikk PEP-Profiler.jar og kos deg! 
  - Alternativt kan den kjøres gjennom kommandolinje som java -jar "path til fil"/PEP-Profiler.jar
    for feilmeldinger osv. 
    
Bygge jar selv (hvis man ikke klarer å kjøre, eller ønsker å bygge for annen JDK):
  1. Clone prosjektet i din IDE "of choice". Jeg bruker IntelliJ IDEA.
  2. Bygg Gradle Prosjektet
  3. Kjør "Tasks/build/jar" (i Gradle tabben til høyre i IntelliJ)
  4. Lag en ny mappe, der du ønsker å ha applikasjonen, og gi den et passende navn. 
  5. Finn PEP-Profiler.jar (ligger generert i build/libs/PEP-Profiler.jar) og legg den inn i den nye mappen
  6. Kopier cache-mappen fra prosjektet og legg den i den nye mappen (cache mappen bør inneholde cache.txt)
  7. Dobbeltklikk på PEP-Profiler.jar og bruk applikasjonen som normalt

Kjøre i IDE
  1. Gjøre steg 1 og 2 i "Bygge har selv"
  2. Gå til src/main/java/no.arnemunthekaas/service/serializer.java og kommenter ut linje 23 og 38
     og fjern "//TODO" fra linje 24 og 39
  3. Kjør Main som vanlig java-applikasjon
```

## Tutorial
https://www.youtube.com/watch?v=SbQAdeB2miA&ab_channel=ArneMunthe-Kaas

## Kommentarer
Maks resultater per API-spørring satt til 25, for effektivitetens skyld. I tillegg så fungerer applikasjonen definitivt best på personer med egne Wikipedia-sider på engelsk, gjerne med bilde. 
For å forsikre at riktig Wikipedia info hentes, så må navnet på personen som søkes opp matche bokstavrett med tittelen på deres 
Wikipedia side, dette er for å forhindre at feks. Kong Harald matches med Kong Harald Hårfagre sin Wikipeda. Dette kan føre til
 at personer som trykkes på ikke får opp wiki info, men selve PEP-sjekken kan dog utføres som normalt.
Jeg er noe misfornøyd med løsningen min, men jeg synes den har noe nyttig bruksområde. Om jeg hadde hatt mer tid så ville jeg
nok laget en webapp... Men forsåvidt er jeg fornøyd med mengden funksjonalitet jeg fikk lagt inn på 3 dager. Prosjektet er noe
 rotete og dårlig planlagt, den fortjener en fin refaktorering, men per nå er mer en type "proof of concept". UI-var dessverre ikke et 
stort fokus, i og med at jeg fokuserte på det rent tekniske som lå til grunne, derfor ser applikasjonen noe "90s" ut. I tillegg
 kunne dette også vært en JavaFX app, som kanskje hadde gjort den mer responsiv og robust. 

- - -
 ### Forslag til forbedring
- Webbasert løsning: Dette gjør applikasjonen mer tilgjengelig, men grunnet mangel på tid, så valgte jeg å lage en desktop applikasjon istedet, i og med at en desktop app er enklere å få "up and running". I tillegg har nettlesere noe fine innebygde funksjonaliteter som man kan benytte seg av, fullskjerm, vindusscaling, historikk, cookies, caching, frem og tilbake piler, alt som kunne vært nyttig her.
- Caching av data: API-spørringene er treige, spesielt når man gjør mange av dem, man kunne cachet mye av denne dataen enten lokalt eller i en database, dette kombinerer seg også veldig godt med en webbasert løsning.
- Finere GUI: GUI er vanskelig i java, hvis dette hadde vært en webapp kunne man lettere benyttet seg av GUI-rammeverk, som kan gjøre applikasjonen lettere å bruke, og mer responsiv.
- Ekspandert funksjonalitet: Kanskje man kunne søkt på flere typer verdier, sortert resultater eller hentet relevant informasjon fra flere kilder.
- Support for flere språk: Dette er nok en ganske stor oppgave, men hadde vært kult!
- Polish/bugfiksing: Denne kryr av feil og skriker av å være et unpolished program, dette steget her krever dog veldig mye tid.