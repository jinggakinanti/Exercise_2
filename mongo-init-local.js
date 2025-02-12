print('### STARTED EXECUTING JS SCRIPT ###');
print('[WARNING] THIS SCRIPT IS ONLY EXECUTED ON FIRST MONGODB INITIALIZATION [WARNING]');
print('[WARNING] TO RE-EXECUTE THIS SCRIPT, YOU NEED TO REMOVE THE MONGODB VOLUME FIRST FROM DOCKER [WARNING]');

db.createUser(
    {
        user: "showcase_image",
        pwd: "admin",
        roles: [
            {
                role: "readWrite",
                db: "showcase_image"
            }
        ]
    }
);

print('### FINISHED EXECUTING JS SCRIPT ###');