# set required params (client id, secret, idp url, realm, sp url - locolhost and port for testing)

RESULT=`curl -v -k --data "grant_type=client_credentials&client_id=<client_id>&client_secret=<client_secret>" https://<idp url>/auth/realms/<realm>/protocol/openid-connect/token`

echo $RESULT | python -m json.tool
TOKEN=`echo $RESULT | sed 's/.*access_token":"\([^"]*\).*/\1/'`

echo $TOKEN

echo attempting to pull from token..............................................................................

curl  -k  -H "Authorization: Bearer $TOKEN"      https://<sp url>/api/funcionario/LHNV
