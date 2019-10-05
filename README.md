# White Crow PM Backend



## Configurations

### Local Development
The applications entry point (Main Class) to start spring boot is `whitecrow.application`, located in root of `/java`.


Before running the application, please set the following environment variables:
- `spring_profiles_active=local`

You will also need to create a 'persistence-local.properties' file in the root of the `/resources directory`. This is 
for the database environment variables. DO NOT ADD TO VERSION CONTROL! 

You will need the url to access the local database i.e. you should have a local instance running on your machine. 
Ensure this is in the JDBC format.

This file must include the following variables:
- `url=jdbc:postgresql://localhost:5432/postgres`
- `username=yourusername`
- `password=yourpassword`

## Deployment
A number of environment variables are assumed to be available when running production. Firstly, setting
the variable spring_profiles_active=production and all the variables defined in the file `/config/HibernateConfig.kt`.

### Docker
** You will need docker installed on your local machine, or have docker available to your CI pipelines **

In order to build the docker image, you must build the application locally (or in CI pipeline) first.
This will ensure that the .jar is available to copy to the docker image.

To build the application use `gradle build` from root directory i.e. `/whitecrow-backend`. This will create the .jar and also generate static
meta models of JPA entities.

Once this is complete you may build the docker image by using the following command.
`docker build -t whitecrow .` (ensure the '.' is also there).

In order to run the docker image use something like 
`docker run -e spring_profiles_active='local' -e url='remote_db_url' -e username='yourusername' -password='yourpassword'` as you will need 
to pass environment variables to the container.





