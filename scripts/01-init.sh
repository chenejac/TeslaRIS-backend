psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE "$APP_DB_NAME";
    GRANT ALL PRIVILEGES ON DATABASE "$APP_DB_NAME" TO $POSTGRES_USER;
EOSQL
