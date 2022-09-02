import no.arnemunthekaas.service.RestClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestClientTest {

    @Test
    public void testwikiImageSearch() {
        RestClient restClient = new RestClient();
        assertEquals("https://upload.wikimedia.org/wikipedia/commons/0/05/Wil_Lee-Wright_foto_Rein_Traante2017_MG_0419_%2832592903182%29.jpg"
        , restClient.wikiImageSearch("Erna Solberg"));
    }

    @Test
    public void testwikiSummarySearch() {
        RestClient restClient = new RestClient();
        assertEquals("Erna Solberg (Norwegian: [ˈæ̀ːɲɑ ˈsûːlbærɡ]; born 24 February 1961) is a Norwegian politician and the current Leader of the Opposition. She served as the 35th prime minister of Norway from 2013 to 2021, and has been Leader of the Conservative Party since May 2004.Solberg was first elected to the Storting in 1989, and served as Minister of Local Government and Regional Development in Bondevik's Second Cabinet from 2001 to 2005. During her tenure, she oversaw the tightening of immigration policy and the preparation of a proposed reform of the administrative divisions of Norway. After the 2005 election, she chaired the Conservative Party parliamentary group until 2013. Solberg has emphasized the social and ideological basis of Conservative policies, though the party also has become visibly more pragmatic.After winning the September 2013 election, Solberg became prime minister of Norway, the second woman to hold the position, after Gro Harlem Brundtland. Solberg's Cabinet, often informally called the \"Blue-Blue Cabinet\", was initially a two-party minority government consisting of the Conservative and Progress parties. The cabinet established a formalized cooperation with the Liberal and Christian Democratic parties in the Storting. The government was reelected in the 2017 election and was extended to include the Liberal Party in January 2018. This extended minority coalition is informally called the \"Blue-Green cabinet\". In May 2018, Solberg surpassed Kåre Willoch to become the longest-serving prime minister of Norway from the Conservative Party. The government was further extended in January 2019 to include the Christian Democratic Party, and thereby secured a majority in Parliament. On 13 September 2021, following the parliamentary election which overturned her government's majority in the Storting, she conceded defeat, leaving it to the Labour Party's Jonas Gahr Støre to form a new government. On 12 October 2021, Solberg and her government tendered their resignations to King Harald V, clearing the way for Støre to form a new government, which was finalised two days later. She then returned to being the Leader of the Opposition."
                ,restClient.wikiSummarySearch("Erna Solberg"));
    }

    @Test
    public void testdoPepSearch() {
        RestClient restClient = new RestClient();
        assertEquals(3, restClient.doPepSearch("Erna Solberg").size());
    }
}
