import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.messenger.api.message.CreateConversationRequestData;
import org.junit.Test;

public class ArrTest {

    @Test
    public void test() {
        String json = "{\"type\":0,\"members_ids\": [\"111-111\",\"222-222\"]}";
        //String json = "{\"type\":0}";
        CreateConversationRequestData requestData =
                new JacksonDataMapper().mapData(json, CreateConversationRequestData.class );

        //requestData.getMembersIds()
        int r = 0;
    }
}
