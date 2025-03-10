
# Use official node image as the base image
FROM node:latest as build

# Set the working directory
WORKDIR /usr/local/app

# Add the source code to the app
COPY ./ /usr/local/app/

#Install all the dependancies
RUN npm install --force

#cleaning the cache to avoid potential issues
#RUN npm cache clean --force


# Generate the build of the application
RUN npm run build

# Stage 2 : Serve app with nginx server

# Use the official nginx image as the base image
FROM nginx:latest

# Copy the build output to replace the default nginx content
COPY --from=build /usr/local/app/dist/angular-frontend/browser /usr/share/nginx/html

#expose
EXPOSE 80
