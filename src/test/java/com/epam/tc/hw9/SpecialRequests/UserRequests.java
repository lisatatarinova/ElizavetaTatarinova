package com.epam.tc.hw9.SpecialRequests;

import com.epam.tc.hw9.MainRequests;
import io.restassured.response.Response;

public class UserRequests extends MainRequests {

    public Response getUserName() {
        Response response = super.getData("/members/me");
        return response;
    }
}
