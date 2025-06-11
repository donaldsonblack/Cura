# Stage 1: Build the Vite app
FROM node:18-alpine AS builder
WORKDIR /app

# Copy files and install dependencies
COPY package*.json ./
RUN npm install

# Copy rest of the project and build
COPY . .
RUN npm run build

# Stage 2: Run Vite preview
FROM node:18-alpine
WORKDIR /app

# Copy only the built files and necessary scripts
COPY --from=builder /app /app

# Install Vite globally (optional, you could also run it via npx)
RUN npm install -g vite

# Expose Vite preview port (default: 4173)
EXPOSE 4173

# Start the preview server
CMD ["vite", "preview", "--host"]