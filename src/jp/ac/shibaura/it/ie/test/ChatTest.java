package jp.ac.shibaura.it.ie.test;

import jp.ac.shibaura.it.ie.domain.application.chat.message.ChatMessagePostInteractor;
import jp.ac.shibaura.it.ie.domain.model.session.SessionRepository;
import jp.ac.shibaura.it.ie.usecases.chat.message.post.ChatMessagePostInputData;
import jp.ac.shibaura.it.ie.usecases.chat.message.post.ChatMessagePostOutputData;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ChatTest {

    @Autowired
    private ChatMessagePostInteractor chatMessagePostInteractor;

    @Autowired
    private SessionRepository sessionRepository;

    @Before
    public void testRoomStart() throws Exception{

    }

    @Test
    public void testChatMessagePostInteractor() throws Exception {
        String image = "iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAABHNCSVQICAgIfAhkiAAAGXRJREFU\n" +
                "eJztXXmUW1d5//3um30k24FC2RsgIYlHYychXVhr1uDUHqmUkLCW7kBpS4FSSEMpbSlLTxcgbTjJ\n" +
                "acmBUtoGiMbjdpoAiUMSCoTg2CM5IQ52ISaBhhDPSJpd99c/pBlrebuk0die34GT0Xv3ft9n6Xv3\n" +
                "3futxAbWHcZyyY9QeKHXfRFf3ZMq/HE7ePW0g8gG2gsKzyJxoecA4Yft4mXaRWgDJycirwCZXDIv\n" +
                "6Uy3ewRL2dHC41sXawNrhTgrQC/JHrf/A+hrt4BRkc4n/nT3oSHv5XMDdTj19gDCbxqZKzJTibzI\n" +
                "L1mL6ya2Fe7ttljrFaecAhDsr/wHKQIpY/T2zFTyMIhvSPrSdKI4vu/pmO+2nOsFp5wCQOgHT3wk\n" +
                "SBDPAvAskm/YUkoupqd0FMAhGByCuH+ehTtuHMFPuiVyN3HqKQDUh1oNaEYfyXMAnAPhlwFgUEmk\n" +
                "c5gh8DCE4yKmCRUgLghYsixfPZGavXNNxF9jnFIKsOMoBlCiE2cugU0ANoEr6sOV/4HgrQA2FGC9\n" +
                "Y3Bm8KcQ6+fvDNK54TcSvCDqPEnP9F/F9MxMLvF3kelC+8dTpU/XXjulFGCg19ki220pasExgLsj\n" +
                "z/J9gwGrr7DomABQpwDrxhI4NjX8063SsGVuaocspxPWhQLszifThHlXy4Rok20Q57TCungFOMIV\n" +
                "MHikVToiN1HtkOj0QdcVID2VuAzA+RC+1yotlplYH2vayYOuf10E3g0Agp668zBaeofTaLg9Up0+\n" +
                "6KoCpHPDbwSZAgCCpnc+8dJW6AncUICIWH0FjE0Nv97A/G3QBEFJepxRRQ1kppL/5zd/2Vl83t6t\n" +
                "C4erE95ZZ7Ylfw7AF0NJ7i7bsJdsG3DHqgKQZgDA5qAJfl9w1e7uS8NRby+wgLFc8rcInFs/H1uD\n" +
                "RfaBOLTx+0dD114BBN7eeE3A2S3RpAZamX86oisKkM4lfpfAWU03pKftOIrYPyLFwZYEOw3RnRWA\n" +
                "/D33y+zZMjv0ovh0taEAEbHmCkCoD1ZP9Rxgzc/Hpa2NFSAy1lwBBC6C/L7nfSIVlzYN+uPOPV3R\n" +
                "lVcAgfs9byr+RlDa2ARGRVcUwAKHvO4R/BkonlwEvigoL2jDIxASXVEAA33T8yYxmM4lfyEO3Wyq\n" +
                "eNV4qnhhGfp5QNcAuH9DGfzRHWfQUvEr6k1Ygu4KaPBcAF+LS35vqnQAwO8BwK7c8HZHfD2A57Oy\n" +
                "v+h67sJ6QlcUIHsBjmdy/AEA99OAMNouXlVlOAAAOw9jU/988lIQLxC0neBZOM0VomvuYEH3E/Q6\n" +
                "DsYJdwrE5NmYAQr/BOCfAODSPPrm7PAOx/AXIJwD8KkEniDgDFR8Hqe8YbmL8QA8BMDL6OOae9hu\n" +
                "XD+CRaB0E4CbGu/tEHo27R96PIac5Ey59IM49BfL5bf395i/dL1puQXkdQCeGIe2Bx6C9CYYHXeV\n" +
                "Z9n+uPFaFxXA3u21ByVwxq5D/Weveg27gH3EMjD7YCs0JrfPHQNwrPH6jjwSm5G8he398QHgiSA/\n" +
                "Wp4r7pi4CLNhJnTNGbRYtjf73Te2b8daybKW2CH0bFZiD4ltHWKx3Qwk9u5QuIe7awowuX3umKiH\n" +
                "ve4bqFNfUFexJZ/8PMHndZIHwedtySc/H2ZsVyOCKB71vtmZjWA3kcklrwOwc43Y7Uznkp8KGtRV\n" +
                "BRDgnbYtPmMNRek40vnExwC8Zi15Enhtla8nuhoVTOog5BFeBj15Rx6JfSMoes3ffTB5rmPqM13W\n" +
                "AAezqcJvRpmQnkr+M4XXdUogP1B8c3oqmRwfLfy62/0aBbAPCLwjkKJ4AYkh93sqi/i63/TF5fLM\n" +
                "yt9l2jscuSfzETSbOPSLwOx/etFyzPImoGd7oMxthIDFCINNOpf8PIlf6qBIgSDxuvRUcst4qvAq\n" +
                "EHXJc5ENHZlc8j4AP+N6U5jLjha2RKT3YwDuGT3Sh7KjxT/znjv4c0DPbVH4tQoBd46nCs8PGrfj\n" +
                "KAa2lBJ7Ab5gLeQKA1FfnR4q7q4tkNH1vABBnrEBAM5bM0HaiIvzeMzmYvKW9fTjAwDFF24pJm++\n" +
                "OI/HrFzrugJQ8DT2CHzmWsrSLgwo+SnfOn/dBPHsAZ04HXRdAfxiA0CPV826h0JZ4XwQtM8Ivw9x\n" +
                "xQn5uq4AdKxn5Q0Cm8buTZ509gBf+0YwHhHxVb8B1fvxk2mFIyt/dl0BpjX7VUhlr/tmCYEbrvUG\n" +
                "S/uduHNFfBw24Am3WATxibg8QK3K13UF2DeCokhvbxsVO0i0W7DA3bEmCveNjxQ+HGZodqTwIQj3\n" +
                "xeLjYP/Kn11XAAAgdMTn9klXvm1vqnRAwEKUOYJUNrgyEiMH74sa8iZgYfy80tTK53WhACDcl0zh\n" +
                "vuxI8YNrLE1bQESr6E3y5omRwniUOdmthSzAW6LxwUO1n9eFAlhxqvGaIGud8nsaLVcnEUIHkQgo\n" +
                "lct4Rxwm1uIPBZRCTxDqYhza6wsgnPRU4oMk5iz0wAJLE2EqcMritiZVFCf3bPU2A693iHggbLka\n" +
                "SR+b2FaMVc94Ylvh3sxU4uMg3xuKF1BneGv3CtBH8l0A32dgrhlU8nuZXHJPOp/wTfue2Fa4V8BM\n" +
                "zaWCNctN2cMnFaSwR8G794wWP9AKq6q5PNTGkw1ydfoV0AfgYoi3Z6aSv+E3kDphErbQP06MzPmZ\n" +
                "iNc9BNwTYsw8bPmtbWFoy28VgotgN8oVWQEUw4FEYFjUVelcwvsfS3y3Sv/wnhFvB9DJAmuW7goc\n" +
                "JFyT3TYbPC4Esttm75JwbSBL1ssVaQ+QzieupvC0qMIBFfeugA9n8kNHsyOzk02CAfcAGgP43pN4\n" +
                "47eKvVsXDqen+ma9XOcCHhV0ZGwq8WYAMNR0NlX6XFj66Xxiq2xjYyl9V+CjBM5w5SnM7hldqMvL\n" +
                "DK0A6VzyGgq/Gna8Gwj0Q84nduRxfmOgh8i7jPDf2VRhohUe6wnVI5erQ4vAGST/vubKMQChFYBg\n" +
                "mkSklZJEU5RzqFdAOpf4ANHaj1+Dp25WsqkY1VJfYR+Wlk7ujV8T1FJYebshNssTqADpQ0OXQHxn\n" +
                "m2W5bNeh/ro08MmzMZO9YP5/28ynuxBbLn4ZmzXU5GWlizy+CrDzMDbBOleR6G2ncAQGHNv75+2k\n" +
                "uR4hfxN3Z3kLf6GGOgyq8QKuwFcB+heSHyfw5HYLBwAUd7ajQvh6Rt2RS5gD8MCaMXfsAmlfB6Cw\n" +
                "colOc+yF5yZwd27oZyVdyk7lRxKDBubdAGK/Xo5z7tAWJi9rWZYydoN4fct0GrBky9/sd3ogSCSu\n" +
                "FHg5vTKiO4DsSOnuTD75LklXEzR2vtxUl8FTARyYv0SlF2DHIOAStKAAlZNEIduqHJlcsiMOp8nt\n" +
                "c8cyuWSB4BeyqcJV6Vzy8jDzaHC7fGIkaPg/CJnWnh0pXJfOJS4ScNmeC5tzHV1/4F0HB58j4IWd\n" +
                "zo0m8IzdBxIvnthe9M0T7CTGDiZ/G241C9sEAZ8eTxUiOXqyI4W/CRqTySdD2f4BYDxVfNvYVNLV\n" +
                "Sui6B3BMz3s8q3e0GY7D164FHy+Qeluk8UAk/3vUH79T2DNacG3I0fQjX3xo6IkA1jIz97lryKsO\n" +
                "Y7nhX6323wkNAbd3Sp5uoOkVMGCd3yfil2uNCkHPSOcTW8dHit7RwR0CwT+IMl7AT6ZZCNwvjN2b\n" +
                "PMcsW7ckUFcTbRWDmdzwqiHMigt7RotXVzqPnYjjX5XFarvfBt1Y87JMbti15J7tMZN7zi18B3BR\n" +
                "AAq71rLiNkHKIgO/8PAOYCyXuJzgSMRpn/PLVVzFkl4Emo9EpP1Y4MQcQxQBXA2Y9wJoSpQNPpzx\n" +
                "LZ5+uyXNA5UorLpXQCY/fL6olip2xwIRuzxsXBjwDyNNEKbnWXAv93ISo34PIPOGbhRGIhD1SWwJ\n" +
                "mUPJDIDzo8wRdf2p2F+4TgEExCrQ2CoEPbk2X63j/Cz+KNJ4oDRv7Cn39AM1CnBpHn3U2j6JKyBo\n" +
                "BpWIXyY+AtKHhi4B9OwocyjccOPW2YeCR558WFWABSTSILpXbl2M9KPEBeW8O8prTsA8lpf+opMy\n" +
                "dROrCmDEljp2tQpRT+80j/TB4ZdKivaakyZOOTd1DVYVQGo9nVmQIExHzYoBAIJPaZV/IA/D90Tc\n" +
                "5C6WnaWWInbXO1YVgETLTyDF+exo4fHjI4Utgh2T8O2wcwU8oVX+fkgfSL5AQKTybIL+u5vFKtcC\n" +
                "BqgUW4JXmZY4IOx4qnTjeKrwPFC3hpvS4VOAgyui+DckLcPRKR+0YgDAmA6lYBMWi8VX+xWEXIGg\n" +
                "4d3f8ig+1SIqtYQUzb9Bfrk2ifJUReWJoEKXZ5e0HIVB9gIchxiYy06QGBo6N2hcPPRcGenphyyx\n" +
                "fFImpUaFAQCCIc2/up1+ufwe6GPh7wQ8GkKYtu8DMvnh8yW9JOK0W7OpOe+uJqcQDABICvziBTyK\n" +
                "pWXf9C4vXD+CRUhfDuRRZtv3AbLmTxkhskmQKIQq0nAqYGUFCPziCV3VynmYhoEKYMhINQaDUE1K\n" +
                "fXm0WTxue3lKWv3cUFkB/P3UEDBznMW/9xsThIW+whcD9w9k+04iAGjx/qgh7QTO4LJOSbu/G8zO\n" +
                "byceFxgAQkyG8oP7YPJszJD0PQ0Ialv+wa5D/WeDvCTe7PVV4LGTMH0OA3feYvnf28JNzblpdbdD\n" +
                "NjkIA6fc+37EbAhF4IzdBxO/2C5Z1jMMHRtkgl2cGZz9SjuYiZrxu0+wLStAZv/AmSB3t0LDODgt\n" +
                "FKDHwiT8DsiSjtYWF24FBH3pUNEibr2g3t73txzXqPh1ig1wr6QbVi+QLyGwKZglSpBuqs6Zq16e\n" +
                "lPSkE7TgEByLIM6Dkr7RKN/K3z2GGvCq2V9lGK8WnSu06Ftfgt7JEGEx9u2hJ0HItBrXSDF2mdrs\n" +
                "aHEfgH1ApWr45lLy/0LxBIatYz9TWxupMax8bCrxShKhFUCAxkeLngkpRmKA+ZWBBpzwwtC/u7fQ\n" +
                "sgKYPuf9nv0MooB4fMs0AGwqJi4hwnc1N9Zxjd9fAYkXR+FP4MlVX487vxAdtwsB96NI47/JIyKZ\n" +
                "mRtRTTZ9VSs0VqA2OacMEelEIeg5/htQXhRZBgcZz3skA46A7k0I44DyfzKtGDmOoI4++T4AiVZo\n" +
                "rNIC2uKckhgpzoIgHYd/7HavGrYX3V8iPMfrlpGCDCVstfT5CTkk36eKjF9m/eI8HkPx1XHnu8EM\n" +
                "D7fcr4Bxml5Y7cgcHGoKkVuwiV3xwvbkGQFtQP/3LqXN0Rl6EfO3OMLGV7YBJa8E0T5ZAUBqKZU7\n" +
                "nRu+OJZMpCM6f9J42RCxwvYIPqHiEm+GMUEbrzZ9qTsPYxOAx/mNkaNY1sYq7bYnmco6LRbHMBfH\n" +
                "nUniZY2bt1bC9oWeV7pdN6KWfCcKj43LtBa984mXBvnkzbJiJV70zSev9CqN1hJqz9/x0ErGU5+h\n" +
                "VquH7/x24nGVDufxQI9wOFNjcPCY2BQrECtt3LCxpl0zyjSRYw12fwtDoDrSk8+QsRWgHXkWBHft\n" +
                "zg8+DQD6+vDqKG7tJgijO442G8cM5G+eVUPxBPkogHxy56Xg82vBKTR12g6C6U/8CcGfijqvWrPH\n" +
                "H4xfzmVJw7/Scp4FMWiscwUAUIx0/nejtaU4fGnjZaMABSAwvPtA4gRzytvBQncF2DU1/HIQz/Lj\n" +
                "I2A+qsfx0jz6QLwhypwq7p9zyuc1FKh2Eyq2NVAwr4g7txZcyQEnWk+cIZtS1g2JwIBNx3B1iaWl\n" +
                "5znbq3pGD837guPxo9sbFmzivQQjVRoTZAX7jhu3zj5E6IDvWOnMlSW4EWP5xKXVJFMvuO66I0P2\n" +
                "9t355PMBPLF1YmyyBxiQwaXLiPRYrv+s6rHGb1lrUoD0VOKDCPFlMETMYC12CD2G/LUocyqM+JXx\n" +
                "VOnG6idfPwfJHgc9n6w1CGXyw+enpxL/Rovr5GGUqXQ6az3TSdIylksTDtQu+8aT0geSdZbJnumh\n" +
                "4pHNpYQCntCkQd8dEvp8nSyqL/KcySffKauw5V8jtUHbcij5R4j4VEhaZs3O2kL3myCvkfASZyD5\n" +
                "/XQOPwSUlPDTK8uy5H5ENkt6DdpQX4/gkewFOJ7JBW+gQ6NHrwKw2m63Z9/TMZ/OsYBgd+WWwH9S\n" +
                "1Za/8zA29S0kPybpNQz7RYjh6+oKBnnECFDlTdmR4mpjBWPMkZB1yZMEks2eTLmHsJFRo5DdQU1l\n" +
                "9g+cKeCcdhVtoOrjHKpBocH7gDAQKjF/fQvJSQKvjZaFq9B1dcfyw29HxIKLkpatU67L8l22tpUG\n" +
                "jwCaYxgz+7EFEYtP+OBr6O15fTsrtgk4Z+dU/6qJe4Xwj9pDnivevOiBHVTouAND8zuR6RveMrF1\n" +
                "ti5XkfOlw1HbrtVBLqtmX+INiBmKVk9awtLyXqBNq0kVBE0/e9+08nklKrhd7VkWqlwi7+jVY74R\n" +
                "PArI5BJvg3BmJNqQhcVfNV6fuAizrTi7aDTczIvtOf6BP5jrm58R2nD8a6a+GipfWQEU/unzJQst\n" +
                "VOlNR5ooTK+ULQseGt27RuK28dHC1zwoxo93cDkS07bHJC0g16/hN0UJJglNW0rtPDD4FGBFARy7\n" +
                "33dGaMIVszIjdvsUEPr9L+l/otGWVNZHve5T9DcG+dNuXgG8mmBGBKE7DeKGtQfQJnv6HefXgKoC\n" +
                "TA/O3oyWW5IDpEpApaBitInhawSa5dJev2bTzaR55/i2kmdWkohoq1UtbbLJJkJYX+OSJxr+TWWL\n" +
                "26Do0T/h2VUqwhgA2Pd0zEd5Cn2IzgDRTxVRnursBTgOMnyKmoFv4eWoq1UtRLlEDFmPVw3gWzmF\n" +
                "fEjQj6rjfuI42NbJmk2k5oE6x45az4WvPk2W4U8VguySLe+NwsatHYrrOOFgpb+uL+LnAboE1GZT\n" +
                "c9/0bOUqBShupQ8wobzEliyJQacbgXmgVgFsJYy5Jajy5Avhkysp3j+5fS6aF5D8VrhxNrAugWoa\n" +
                "VkaHBiE372jzDy3qYdB/v1GW/WxFJu5HQyx/dNDXxkHYO4HaKmG9/HzU4g8uRKv+/OXwXyrhuWR6\n" +
                "TimXvxQ4SLhvPFX6dNAwa5iLyn9VDtBcfM9QkzOKQnNdIcvvBtHbO1q6CcAxmvLNiwPFSb/fQ4Jv\n" +
                "IA8hz429ILuwWMnWXlWAG84rPEIw3gamCuvofgCYGJn7ftiNmqy9Piqf7LbZu4IKToj6ZBhaPQa3\n" +
                "C4rdqHJQLt5IolmpTMjXFjB+fOvsl6rJtN77sgDDmSw8azMRfHDywuLDQENwh4VudJ8SEuXapZmB\n" +
                "vn0BR/x26H4g4ddt+3vjqeI/hKFTVfzIkUgrWLbNCSTLbst3maEqjtj5wpX7VvIj5N1/mOCdfnTU\n" +
                "Y48BcH21ClpdoeoUYMGx14RpQOyBR/aMlk5s/hicUELgv2Lygnx8+SL+OSK52K8Bw+biGoOmtK92\n" +
                "iRYkLZdDPVwV62QV9FzGHwEReBKS52uAq6tRnQLcuHX2IfCEqzAKhPqedEJAqJkwa2U9DTQh+Ll2\n" +
                "7hD0oz4UmjqT+hOzt8SVA2q2/F0/gkWy1rzOB90aNgWSFl17KQkI9aqm5P5b1qxQzTtY2U/EcZCQ\n" +
                "qne0kP4GFoOJuhUjImbgsUkSPnP9SDSj1pwpfSbuymeMZ1mbmqaN8UztVfN180oqhWpbs2DtFxr3\n" +
                "N4Ks6TlRrqdJAcZTpRuD3i9uWLaqO8tLvha2wuLy8hVRedRi3wiKYP1RR8Cj06b4oai0qn0AYh2D\n" +
                "reCqALa2aSR4t9uYUFB91JIgWfELYaZObp87xobjIMEf3HBeYTX4xtXPXLa6MsqRUMCR6hGmFp4e\n" +
                "QQHXRj77uxJS3bub0L/FLWVjib+OcxowHkEhhFYfIrIcqlqqG9RwoiD4/YltBb8NcAMB3FX/sf6I\n" +
                "6qoAE9uKt4L8bFgelHU7cnmFeN09niqE7nnny9fUrVTFhUXELu44MVK4HeC/RJ4o98JW8yzeXAlA\n" +
                "xfzxrbPBdgtv1J0eBN3lNdANFrZu8ykhX/vZM9JkfKTwZgEhXgW6LTta+ljjVaI5y0fQDxe02LYU\n" +
                "LrLu2HrDytk2LqZHCm9ByA1WFQ+K1lVpKq8VPkTp/n0tpL1rsfxftXsyKrjcXi36Tek/pJqThWmq\n" +
                "FuIBwk6z8Ar/Ys+67TiLrqHRsvUOIVEPl2358snRhUCLWFjcsLWYE/RjAfPl8lLLpV33EcvHhwsv\n" +
                "lPCffhthAfMi/p0OLqqJMG4CoSMiD7Yi054LZx9csVMIWDhuCpEKdlVPJHdX5suaxWLdauSbalR5\n" +
                "nxZfPpZL/paBLgf5FAhlEUcJXJ8dKV7nNdc6/KGz8hUK94G4bO+2uba3hmOlHs/DE9vnW4zvq6BS\n" +
                "D6nwyvRU8rkA3iLgLBKPhbAA6kcC7uDS8qdCFs28RxYtO9lE3EvhKQCmYu1xpFtBPhfgsewF9Xuz\n" +
                "ULlme1KFawFcG41p+UHBmQHwmelU4d2tLIO+bMBvosf+a7vpVo9gkf0UtbDQtxZ6bOPmODJocQCV\n" +
                "1PBYNhrby89xWe8B2XQc7Vh38AHOHpgBzul0q7Xp4cIH2lXFrN2YGSl9th2KL9pbAb6jDH0uzvw9\n" +
                "5xa+k8klj8g2B950TAGqxpiO99lbrz8+UNlTtIPO9EjpK5vziXv2pkqxnXUSvk7q643X16RD+AZa\n" +
                "wz5iWVJgS3lfEDdgqdhU8LNjK8AG2os9o6XoNooajKcKE27XN1aA0xwbK8AagkBeguN6L0IcJQBY\n" +
                "ax8gjGdXNi0pVLLt/wOAuW8SUBh4SQAAAABJRU5ErkJggg==";
        String iimage = "iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAABHNCSVQICAgIfAhkiAAAFq5JREFU\n" +
                "eJztXWt0XFd1/va5I82MZiZ2MBTbxI/QOEAUCccxpUkoiRcLKAXSUGpDugjQAgGcCFuaEGhK11Ip\n" +
                "q7QkkpxlSEooz8IKIV0rhLQ8mkAeqzQ85JdGipO6IY6dhBQc43hGz5l7vv6QJUuj0T3n3rlzZxTp\n" +
                "++erc8/Z8v20z9777L0PsEhwoDPzR/WWoRGh6i1AFBjajrQIfpDrSr+r3rI0GhYFARBPrxNBE4Cv\n" +
                "D3alr6m3OI0ETwIMZlteM9CV6tp7bcvqqASqCZReCwAQEYr0DmbTf1dniRoGngTQVOtF1Geb4urx\n" +
                "XFfmnlxn5gMHrkv/XlTChYUS1fqZ/ybkk7ls+gvcCqdeMjUKYl4/VGCSEACiIHgTBG9SxOdzXZmf\n" +
                "i/A+7bo/dpaP7mntxkRE8gaCQNZVePrBwTXpFYc6Cu/bsBvj0UvVGPAkACktkPKnoiC4iJCLxIn9\n" +
                "rT6ZGc9lsYfELyB6wCEfGS2MPLb5NozUTmx/EOE6zP1FAJF3jDWnlx/qKGzbsBsno5es/vAkgKgp\n" +
                "DeA1CHEAF4vgYkBBCxDPZJDr4rOEPCngMwCOAzhOkQKoJ4Tqiba+/F2h/RYGkLJe5v01ZMtYc+Ye\n" +
                "IH9pVPI0EgJoAEuIrBRg5cy/PAEAUQD4AIDICCBAhS3gNEisiEqWRoO3G0i0RCRHzfDo9chAvD+w\n" +
                "AE9EJU+jwVsDQJJBFUCjwC2m1xqjHcIjkQhThlxX5sao1qLwnvaewkPlz402QEXjaSFB6bUweHsC\n" +
                "eTIiacoX/lh0S/EpAHMIYNgCZMFvAVorz/1/clB9NEAjwJMAFC54AlBkvcWYJQJUglASUQlSK0zG\n" +
                "ALyhi6UlAlTCC0EDoGIU8DRIltqfHf11VNI0Gl7wNgAIzy1ARI7InXCjEqfRYHCQmIpGjNpgaDvS\n" +
                "phgAwPp4AA0CTwIoWeA2QDK91jSEXLwGIGCyAbiwbQCCa0xjVJ2CQI0CbwJAFvQWoGnhAi5tAfND\n" +
                "hAt6C6icBzAb1EtbQEU88X4kTh3dLVgQNNsAizgGAHgQIJ9EMkpBagGzBqAuTow9FY00jYl5CaAT\n" +
                "yQVtAAIAhN42AOWZzbehGJE0DYl5CRCDXtAa4GgnkoB4JrBSeDgqeRoV82sAxBY0AY7rjHH/xyKP\n" +
                "AQAeBGjrGx4k+EaQXyXxfJRChQEV00YCLPYYAOBBAAHY3lN4qK238JEzmV9HjW0Ebl8oZNAw5wEs\n" +
                "dhcQMGQETWFNH0aB/N0A7h7qRrPOpy4l1R8DeLMINtRWxGAQzJMKPgOEXtRBIMCSADMxWQQyfC+A\n" +
                "ewFk92YT62JwXieQ1wG4GMC5jRA/EMpaUzZbk6glDVDtBJt6xp4E8CSAbwGTJ3Buc7KNTqxViA1C\n" +
                "nEPBagWsJPBiCJqrXdMSxi1guJBf1DEAIAQClKP1FhSA0YcBPFzp5+yGeqQG65ZDgHX0HMHfNFL1\n" +
                "Ur1Q8w9RDumGBmpbS3ioA/ExcJWnDUBZ9DEAoA4EiAJjifhZ0PMXgwEAUX8XUNH9w6jWKin1dKXn\n" +
                "L0gCuG7TWsdUztAAQaDW3pF99Zah7tZ6LaBsjoGXgkAAXqAEAM3HwDHRSzYAXqAEEBEjAUTU0Shk\n" +
                "aXS8IAkAMWuAEaewRACEbATu70y+TClZqbWscEQVxt3SU5tvHo18rxXIeu8YAE5s/qeFcaZRa1RF\n" +
                "gP5PYFlzKfU2UN6qIBdRsBoAnFN6JR6LYTCbOazJb06I3Lq5J3+sepG9wW7Ecid5lnh7gYv+DGAK\n" +
                "gbaAgWz69bls+vZ4MXNUoL4iIu+c+vjlILBeRD4VB3KD2fSfVyeuGfvyiZeJiHc9OJc8gClYawBu\n" +
                "hTO0NrWNVDsBbATgt3XAiwj5Vq4zc3ZbX75mjREUmoy1AKxXP4AGhFEDEJCBbOaKwTXpPYT6GuTU\n" +
                "xw++4mcGOjNXVzWH5/TaGAOQRV4LMBOeBBjqarkg15V5UIA7IPKq0FYV9A5kWy4Mbb6ZU1OZU8EX\n" +
                "cT+AclTcAvbtxPKYk/60Bj4kNXAVRdAEOrdwKy4OvTJXuNaYCOK6SwQ4hTkfd39XektMZfYA8uGa\n" +
                "JnYINubWZP4q9HlpDgK57lIQaArTH/hQB+IHspmbHOAHEJwVyeKC69gdbixCxLsfAIHRTbsLvw1z\n" +
                "zYUMBUwGcEabMvcqoAMGBzpMEFg/eDL9zhDnExKeGmDJAJwNNZBtudAR52ERvLYeAgjk/WHNtWdn\n" +
                "y0pTypngdCLIgY7kWQOdiZeHtf5ChBKoiyHy0noJQHBL/46kuYjDAgkx9wMAeWTStU3/vWp2Dolq\n" +
                "OjiQTd954Dos6FL4oFAEj9dVAhFJOM7bQ5lLOVYdQQaymRsFcv2UkSuQy4WZL4QiwwKDUkDN4/Mm\n" +
                "EPInYcyjLfIAoPgGBXSUPxbgygNdychStMoxtB3peqyrUG8NAIDApf1XV9+Y2iYPAJAt8/4ETmSt\n" +
                "W8uhE5mb67GuGptw604AETQ1Z9Kbq52HFi1hPOWAvO3R65GpVg6/GOpquQCC9+SuS7VHvbZynPHn\n" +
                "ol60IigXVTuFTVdQ7wkQd0uZeTVEraChLgcAoYr8RjO1cReeJ9kAjRIZwtmAORnUBJe4rHo5/IHA\n" +
                "5QBA4sq9HemXRLm2EoAiqLsWEJG2at4/eE1mBRCCKyeoeivyg4HOxMtF5PxTa8ebmuVDUa4/FQqu\n" +
                "ux0A8uxq9l8dd0OJJQjw6iivkxMVe+usB+SHh7ojq5+cJAAbwBWEiJRKqSqico45CGQlBxKD6+NV\n" +
                "GZP+lpO3zH4gK918amtU609qANZ/CwAAsWjqMB+oLGIAllClWCQ9D4a2I01i7qXWVNdGsT5wigCN\n" +
                "YAMAgIahq5cH3CpdwJkoQSI5H3ATLa+vdHYhgk37s5nXRSHDpAbQDWADAIBI4GNosYkCWothE1AK\n" +
                "YR2oN8/3MwecE62sBSY1gGL9bQAAJIK7QKF+tPDI5AmReQkA4PJ9OxM1t0ViAOBqHFdV5P6QHBSR\n" +
                "H0PjYVHuUxQZF2KVpnqTCN4DYLnNPAIEvpjadDmkz7lWhjXXfBjsjJ9D4GwPKZSjmj4KjH2ilnLE\n" +
                "AEA5PAZDKc0cECch+Koj/MZ5PYXBCiMGAPyof0fy5mbHuWva1/XGi31KAWDycsiiixcFebciRFaF\n" +
                "Ntc8cFXzZRZ/c3/56PX4zCs/h3yt5Jh0A0v2B0IEj5H6r8eb8ue09eSvP++mih9/GptvHj0yUSxu\n" +
                "AzBsMX2gOIDrpsNxAU+BQM0JoIDXm8aIYNl4MX1VjeUAyJiRACRGQH52IlY4r713uNdPbd3m3eOP\n" +
                "C/A140BhIALYXAzhBwIkwzidNMBIAAAQqe12FAOAYgzPxT2H8bsTrvvxago9Xdf9pnIcz8MOQgIR\n" +
                "QGu1Luz85aZ48kXAaE2aSB3sypxbstUyou+uhQxTUABw4ZH870DOsQIEOOxq/fa2nsK7qq3ybV8+\n" +
                "sh/E77zGCINdUCEW5eB+oeKqok0xmE1dWW2otgTY+vhPt/WM7K1mLRMm3cA74QJyYvopSZD/HHPy\n" +
                "mzf2Df9nGAtJNzQEB70HibA7QCFKDfx27apllZ4T6iM6n/5e/ydQ8ec2sE/A5b8LfJvnvjDzP3sq\n" +
                "GniUxJvbegs7amB9Gq9pD9RD0JAKHgRK5vnAxEsA2RIvpR8ImsyqydfYjHNL/I8g8/vBaQIIjoH4\n" +
                "TsnNb27vKzxYi8W0xanj6DP+CRBmDOA09Hyxi1PBKjkv4cQeHNqZ8lUsO7QdaREY6yxJjCx7frgm\n" +
                "32EmpgmgXL2jrTd/1QW7cMLrhWog4KhpzIoJaD9zHupAnGDobpumnFH+7GgnkhBMP6dgtXbUT/bv\n" +
                "SHlF9GahFM9cYFNyJ+CPz/4axuwlDoZpQVp3De+v9WKguUPo+mF/V7g8j/hZtahmUhWuzPutSlSK\n" +
                "VKaUI3flOjMfsJpX0UpjaJEf2oyrFpE2iRLC28on6bdaOO6YG0IEgSjOSdOOQVWMVIqIA4Vbcl2Z\n" +
                "6yymPs9m/WKpFIrxbUKkBNBKvMMNEN8XOEmIeQAzoSlz8/QJQwUVzelkNPdZIPlYVM21otYA3hc5\n" +
                "S4AbvPy7gDcI+SXztHOvzRU43lE5wW+Mq1sYgKDcZxwTEqIlgBiPe8f9zqkt+gFMg/xpW0++BzAT\n" +
                "gJBKl2Z5agBq79S6/p0tq2BxMqoc3G8aExYiJQDpXbsvwEm/c/qKAgo+DwCtR4cHQYOFXfHibHpq\n" +
                "AAo8+w40KYu6BZJ6OP9fxnEhITIC9F+NJoAe598AEaR5o2UtAFFIP1f4PjAV+aRnUEqJzDFYTaeE\n" +
                "Dry3ALFJXBUcbL/VO2QeJiIjQDKVPldEDEEe+iIAu6FIWHkBBH84268WzzYxBOdsAQLvPAGXYrAB\n" +
                "zKeWAvmFaUyYiIwALuQPjIMovkLP+461rBRBk81YkuVulffH4lwNIDC0ztHecyqIkQBaY49pTJiI\n" +
                "jAAiuMQ0xu8W4Dj2eQCuch+YLZB3JjQx2wZgN2IUbxtAS/7/POe0ONunlAZMY8JEJATgVjgUvsU8\n" +
                "Ep7/geUQx9wQYlIAHDl1u9nMZ95H02VewODJ5CrPEC4xYQyj05y2FuPo/5jGhIlICJBbm75EIMZ8\n" +
                "PwGf8TOvbfo2BT+tsJa3xyGzM4I08DJvWfBrsyRiIsCJ1r5oU/QjIYBQ3mc1TuCLADY3gwAANecY\n" +
                "VhRvApCzCaDgeHobhA0BvDUAyYoXO9USNSdAfzbzYgrsWsG5YvOfOA3CTgMo6LmWtVYFr3dEmOGM\n" +
                "lqMiJneTz1qI4hkEUnUo0q05AZrBHQJYXUWvpeiLAIA5sEKylP7dyNzMZaU9CQCIeuz60317SJrK\n" +
                "xYyyE/A8CyHEeFweNmpKgL3XtqwWynabsSSKbcvGfB2AiEUQSCCDFc/VqYxp6mPF5OmcAIEnAQRi\n" +
                "3L5MLisrnD/UGjUlQFPc+UeIXfcrET4u3SjZzj3wUZxpMzeBAxXXgzYSoNlxzpwx0Ss916H2JIBN\n" +
                "IqlUSEKpNWpGgFw2/WcA3mU7nsRjfuZXyZTd/q9Y0a8eK5YMWwAwoScPrw5ek1lhaqaptbcGsEx1\n" +
                "8/Q0aoGaEOCRj8c3AHKrn3cE8OX/UtGqkrikMVTpeVO8yRh1VMLVAFBqorl9DcXTgl8Wt0h0EazY\n" +
                "35mMlAShE2Boe2qlq5vvgWVB6BRIPuJnvHbtmkk4buV5iycLRg2gIOcCAESMWbyxYt6TAOessMt1\n" +
                "cBAzh8wDYKir5YJcNnND+fNQCdC/I7nWTaj74Fn1WhnUylcM3CYIRPBY283DFaOLm2/DCElPm4OU\n" +
                "TZOLGTuHHW+9Bd5uZTc0QGPCK4Wht4cZ7Eq91xXnfmCuJguNALnOls3xWOwBEfhur0Li+fab8z5D\n" +
                "oOYgkBCehasC47HrZbnO9DaCpt6BlhdQmN08gbx177UtFW9g84vcjtRLc9n0HRT1JQGSAplT61A1\n" +
                "AQjIYDa9HeLcj4BGjAC/9FsBIzZBIEMlEmdWQ1V+vxlK/tV0DR3t7yAwp9wLErFmp9tyvsrydCM2\n" +
                "mE1vp6NygFwx9VwTZ5aPrYoAB3ZkXjHUlb6XkD5Tn35v8JcB3jETQONRw4hQIm/219DZ5TsI+N5c\n" +
                "Z3qbbzm2whnMpq4cymcOENInZdVNInPtskDXtQxtT63USbmB5AdoTPIwg4Kf+Bl/tBPJEzZ3HDAa\n" +
                "Ajj0zi6aghDP0aaCYbLO4cuDXanE+b3D3zANP9SBM8ab0lcNQq4B8PvzDqygAXx9vINdmXNdsEND\n" +
                "3gsgEVI5xrCTKfzMzwv5WPwsm/qhYkl72hViyOGzBZXdVfQaeNb6v0zQTKgv5bLpvyDx5WSx8KMN\n" +
                "u0/nTA5tT61kQi4h5IpRwdutwu3CZeyGmjRIJ2EkwFA3mvXJ1DZAriqBl4ZehaNxf2u3uWJoJorF\n" +
                "pjXK1MuTOLnp8yOewRlqHAulr0BJ/cpuoHesYJ53tohgy1hzBrksToB4DoIz9YyTRfsPImrPKDKY\n" +
                "kXhjJIAejq+BqC/7FdsWlDmpWkaIsjoFNEYWldK/YbV2MMn0iYLVFqAUj9JqD5gXy1FhH/cDVUos\n" +
                "B8amCWD87dVwzKa3TyCQdMXldwO8aBEDwCHTGK39ZSBVhhy1LeLUWltqitqhmc4sAhkJ4KSHa0YA\n" +
                "JXLffIEaL9gEgWxCy0LzCZ4FTIbmNCaKrq/zjlpAy+xYgJEAr/gcCpXax4QijNbfDvSiRTGIgEYC\n" +
                "xFT1BCDNmmYKF64Yf8JYkFJjOBR/GkAAQiT0ZkkknnfGh78X7G0bG4D/axoxobzj93aiGNrezBza\n" +
                "DT3f8XRUYFnjCzsLiKxFo8KvmOLnFUXZCoc0p4PHYsPG/fbVN2EYZFWuoKDyaaPH+J9Xs161IHxq\n" +
                "AAAQEd8fylMIsjThlm4J8u7AyuQqU4WREM/Y9jcipCrDrKTzvk4xBfQV8wgbJPwTgPT/l+oFgfxb\n" +
                "4Pr3JvPF1hRa78sQBCaAAE/6bakzUcRDtbKpbKBUAA1AYWgEIFGEM/HpoO8rWhSDEMb9fwriMxNp\n" +
                "JjToez+fvLlcApx9hAMigAZQCG8LEODWthvHHw8+gc0poFjPTx9GXIWFgtbxfT/4mtWBZecBVgTQ\n" +
                "ZFixgOMczf9DdVOYDUAC1gRQesIzZ8ATWvcHes+Z+E7gNauEgP7iAKdeC0cDaO6otvadNqngYh9x\n" +
                "a+0bfxw25/RzJdETzcOBVPkpDfjfQd4NAbOqkyzdwFCMwDva+gohMN8cBFIjZhdwCgIQhP+/ZMqA\n" +
                "n47pc9/XNTtf8UJ5VpAdAao0AgU4XHLzoVzMLKYae/JZv/EFAg/5lYPAA+ZR80OdMfwdAJHXAjKI\n" +
                "BlDVxQFO0OUVYXQg3bcTy2d26qwEir0HMAUlrq+EFAAQ0VV18mrtxgTIXdXMEQiCxKGO0yVqljZA\n" +
                "MA1AokjNbW27ClVY2qcRi5mLQSRAYKe1Z6Qffv4aiUJiYti31ihHolj4ImhvsIaFMZWadgWtCODq\n" +
                "AF4AMQa420JtPF2SIumdX+/HA5iCACRxp48X7t6w239Lu3Js2I1xUajppVDlEOAwJ4anE3CsCOD4\n" +
                "3QImu2+8pb13JFR/t21X4aAiP+g1RjQDRfbEmbjNNkJHza8HWaMSzr8pfw8AY95fGBDgR6LzF830\n" +
                "xEI3AkkOUnBZW2++Jm7O+X2Fb4P4m/l+LkpbZeeUo+3G8ccJud00jsTPw26nr0bznYC/yihfIAok\n" +
                "P9bak//T8g4kVgQowVxKDQDU+ELmeOGS9p68dZJEELT15m8CWLH2cAxOIAIAgGbpU/DKFCYpdLuC\n" +
                "zj8fWm9BwdXu2wSwrS+wA0kCtwOlje29hS9Wqr2wIkATXRMBfka3dFl7X74rih73AHD+kUKW4Ox8\n" +
                "AqKwuScf+BbUjX2jT1Prq8DK+zvBG9r6RoJF/yzWnkDxjQgpX4DE97XWF7f35N/f1js6b+WS5Wmg\n" +
                "W/loleiHxrvbevKXtu8afTigrIEgd8KdyBfeB2Dm8apvF7Ac7X3D94m4bygLDh2Hxvb23uHeauf3\n" +
                "wqaesSe15LcA/KJNHWE5CIyS+LojvLC9N/+OV+8yXzhllaLav7NlVdxxDk8uwmMCfFdR/0tr78g+\n" +
                "v0KGjYPXZFaU4ngIgnNA3tXWW3h3WHPvvbZldSLppl51ePxXfu8xqBZDO1MbXaV2CPBOyPytZUgU\n" +
                "BXiQxN0Tzfk7/EYn7QhwNVqaM5mPAe69bZmRfTMLCxoBA52Jl4uKPUjKt9p785+stzxh4lAHzhhr\n" +
                "Tr2WVJtAvFQppFwg70A/XaLsTxULe2YWjCxaDGRbLsx1pd5TbzmWsIQFhf8HuB3qSptzxNgAAAAA\n" +
                "SUVORK5CYII=";

        ChatMessagePostOutputData outputData = chatMessagePostInteractor.handle(new ChatMessagePostInputData(UUID.randomUUID().toString(),UUID.randomUUID().toString(), iimage ));

    }


}
