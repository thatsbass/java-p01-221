#!/bin/bash

# This script connects to PostgreSQL, sets up a database with a user, and grants privileges.

# Variables
DB_NAME="java_db"
DB_USER="java_user"
DB_PASSWORD="S3cur3P@ssW0rd"

# Connect to PostgreSQL and execute commands
sudo -u postgres psql <<EOF
CREATE DATABASE $DB_NAME;
CREATE USER $DB_USER WITH ENCRYPTED PASSWORD '$DB_PASSWORD';
GRANT ALL PRIVILEGES ON DATABASE $DB_NAME TO $DB_USER;
EOF

echo "Database setup complete. Database '$DB_NAME' and user '$DB_USER' have been created."


#!/bin/bash

# This script connects to PostgreSQL and removes a specified database.

# Variables
DB_NAME="java_db"

# Connect to PostgreSQL and execute the drop database command
sudo -u postgres psql <<EOF
DROP DATABASE IF EXISTS $DB_NAME;
EOF

echo "Database '$DB_NAME' has been removed if it existed."


#!/bin/bash

# This script connects to PostgreSQL, terminates active connections to a database,
# and then removes the specified database.

# Variables
DB_NAME="java_db"

# Function to terminate active connections to the database
terminate_connections() {
    echo "Terminating active connections to the database '$DB_NAME'..."
    sudo -u postgres psql -c "SELECT pg_terminate_backend(pg_stat_activity.pid) FROM pg_stat_activity WHERE pg_stat_activity.datname = '$DB_NAME' AND pid <> pg_backend_pid();"
}

# Connect to PostgreSQL, terminate connections, and drop the database
terminate_connections
sudo -u postgres psql <<EOF
DROP DATABASE IF EXISTS $DB_NAME;
EOF

echo "Database '$DB_NAME' has been removed if it existed."