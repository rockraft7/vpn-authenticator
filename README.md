# vpn-authenticator
Centralized vpn authenticator and manager with RESTful endpoint.

1. User authentication

    GET /authenticate

    Query param:
        username    -   Username for the VPN user
        password    -   Password for the VPN user
        serviceId   -   ID for the service

    Returns:
        text/plain with 0 (success) and 1 (failed).

2. Create new session

    GET /session/create

    Query param:
        username    -   Username for the VPN user
        serviceId   -   ID for the service

    Returns:
        text/plain with 0 (success) and 1 (failed)

3. Invalidate/delete session

    GET /session/invalidate

    Query param:
        username    -   Username for the VPN user
        serviceId   -   Current active service in the session

    Returns:
        text/plain with 0 (success) and 1 (failed).

4.  Search user

    GET /search/user/{username}

    Returns:
        {
            "userId"        :   1,
            "username"      :   "faizal",
            "password"      :   "abc123",
            "disabled"      :   false
            "disabledUntil" :   null
        }

5.  List session.