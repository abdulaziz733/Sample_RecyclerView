package com.listne.utils;

import com.listne.api.ApiClient;
import com.listne.api.ApiInterface;

/**
 * Created by abdul on 6/13/2017.
 */

public class Utils {

    public static ApiInterface getAPIService() {

        return ApiClient.getClient(Constant.BASE_URL).create(ApiInterface.class);
    }

}
