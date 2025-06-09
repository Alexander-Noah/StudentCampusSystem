public class Main {
    public static void main(String[] args) throws Exception {
        while (true) {
            int mainChoice = Menu.mainMenu();
            if (mainChoice == 0) break;

            if (mainChoice == 1) {
                while (true) {
                    int devChoice = Menu.deviceMenu();
                    if (devChoice == 0) break;

                    switch (devChoice) {
                        case 1: DeviceManager.addDevice(); break;
                        case 2: DeviceManager.modifyDevice(); break;
                        case 3: DeviceManager.deleteDevice(); break;
                        case 4:
                            while (true) {
                                int queryChoice = Menu.queryMenu();
                                if (queryChoice == 0) break;
                                if (queryChoice == 1) DeviceManager.listDevices();
                                if (queryChoice == 2) DeviceManager.searchByName();
                            }
                            break;
                    }
                }
            }
        }

        System.out.println("程序已退出。");
    }
}