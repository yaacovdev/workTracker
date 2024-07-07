#include <iostream>
#include <map>
#include <string>

// Fonction pour suivre l'utilisation des applications (données factices pour l'exemple)
std::map<std::string, int> trackUsage() {
    std::map<std::string, int> usageData;

    // Données factices pour démonstration
    usageData["App1"] = 120;  // en minutes
    usageData["App2"] = 90;
    usageData["App3"] = 30;

    return usageData;
}

int main() {
    std::map<std::string, int> usageData = trackUsage();
    
    for (const auto &app : usageData) {
        std::cout << "Application: " << app.first << ", Temps d'utilisation: " << app.second << " minutes" << std::endl;
    }

    return 0;
}
