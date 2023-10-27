package entity;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class ServerURLModel {
    private String serverName;

    private String status;

    private Date timeStamp = new Date();

    public ServerURLModel(String serverName) {
       this.serverName = serverName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
    public void setStatus(String serverName) throws IOException {
        URL url = new URL(serverName);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int code = connection.getResponseCode();
        this.status = getCode(code);
    }

    public String getStatus() {
        return status;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
    static String getCode(int code) {
        switch (code) {
            case 100:
                return "CONTINUE";
            case 101:
                return "SWITCHING_PROTOCOLS";
            case 102:
                return "PROCESSING";
            case 200:
                return "OK";
            case 201:
                return "CREATED";
            case 202:
                return "ACCEPTED";
            case 203:
                return "NON_AUTHORITATIVE_INFORMATION";
            case 204:
                return "NO_CONTENT";
            case 205:
                return "RESET_CONTENT";
            case 206:
                return "PARTIAL_CONTENT";
            case 207:
                return "MULTI_STATUS";
            case 300:
                return "MULTIPLE_CHOICES";
            case 301:
                return "MOVED_PERMANENTLY";
            case 302:
                return "FOUND";
            case 303:
                return "SEE_OTHER";
            case 304:
                return "NOT_MODIFIED";
            case 305:
                return "USE_PROXY";
            case 307:
                return "TEMPORARY_REDIRECT";
            case 308:
                return "PERMANENT_REDIRECT";
            case 400:
                return "BAD_REQUEST";
            case 401:
                return "UNAUTHORIZED";
            case 402:
                return "PAYMENT_REQUIRED";
            case 403:
                return "FORBIDDEN";
            case 404:
                return "NOT_FOUND";
            case 405:
                return "METHOD_NOT_ALLOWED";
            case 406:
                return "NOT_ACCEPTABLE";
            case 407:
                return "PROXY_AUTHENTICATION_REQUIRED";
            case 408:
                return "REQUEST_TIMEOUT";
            case 409:
                return "CONFLICT";
            case 410:
                return "GONE";
            case 411:
                return "LENGTH_REQUIRED";
            case 412:
                return "PRECONDITION_FAILED";
            case 413:
                return "REQUEST_ENTITY_TOO_LARGE";
            case 414:
                return "REQUEST_URI_TOO_LONG";
            case 415:
                return "UNSUPPORTED_MEDIA_TYPE";
            case 416:
                return "REQUESTED_RANGE_NOT_SATISFIABLE";
            case 417:
                return "EXPECTATION_FAILED";
            case 421:
                return "MISDIRECTED_REQUEST";
            case 422:
                return "UNPROCESSABLE_ENTITY";
            case 423:
                return "LOCKED";
            case 424:
                return "FAILED_DEPENDENCY";
            case 425:
                return "UNORDERED_COLLECTION";
            case 426:
                return "UPGRADE_REQUIRED";
            case 428:
                return "PRECONDITION_REQUIRED";
            case 429:
                return "TOO_MANY_REQUESTS";
            case 431:
                return "REQUEST_HEADER_FIELDS_TOO_LARGE";
            case 500:
                return "INTERNAL_SERVER_ERROR";
            case 501:
                return "NOT_IMPLEMENTED";
            case 502:
                return "BAD_GATEWAY";
            case 503:
                return "SERVICE_UNAVAILABLE";
            case 504:
                return "GATEWAY_TIMEOUT";
            case 505:
                return "HTTP_VERSION_NOT_SUPPORTED";
            case 506:
                return "VARIANT_ALSO_NEGOTIATES";
            case 507:
                return "INSUFFICIENT_STORAGE";
            case 510:
                return "NOT_EXTENDED";
            case 511:
                return "NETWORK_AUTHENTICATION_REQUIRED";
            default:
                return "";
        }
    }

}
