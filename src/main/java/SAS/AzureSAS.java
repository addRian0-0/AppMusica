package SAS;

import com.azure.storage.blob.*;
import com.azure.storage.blob.sas.*;
import java.time.OffsetDateTime;

public class AzureSAS{

    // Método para generar un SAS URL de descarga para un blob específico
    public static String generateDownloadSAS(String connectionString, String containerName, String blobName) {
        // Crea el cliente principal
        BlobServiceClient serviceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();

        // Obtiene el cliente del contenedor
        BlobContainerClient containerClient = serviceClient.getBlobContainerClient(containerName);

        // Obtiene el cliente del blob (archivo/canción)
        BlobClient blobClient = containerClient.getBlobClient(blobName);

        // Define los permisos: solo lectura
        BlobSasPermission permissions = new BlobSasPermission().setReadPermission(true);

        // Define vigencia: por ejemplo, 30 minutos desde ahora
        BlobServiceSasSignatureValues sasValues = new BlobServiceSasSignatureValues(
                OffsetDateTime.now().plusMinutes(30),
                permissions
        );

        // Genera el token SAS
        String sasToken = blobClient.generateSas(sasValues);

        // Regresa la URL completa (incluyendo el token)
        return blobClient.getBlobUrl() + "?" + sasToken;
    }
}

