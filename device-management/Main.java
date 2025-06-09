public class Main {
    public static void main(String[] args) {
        DeviceManager dm = new DeviceManager();
        while (true) {
            int mainChoice = Menu.showMainMenu();
            if (mainChoice == 0) break;
            if (mainChoice == 1) {
                while (true) {
                    int devChoice = Menu.showDeviceMenu();
                    if (devChoice == 0) break;
                    switch (devChoice) {
                        case 1: dm.addDevice(); break;
                        case 2: dm.updateDevice(); break;
                        case 3: dm.deleteDevice(); break;
                        case 4:
                            while (true) {
                                int queryChoice = Menu.showQueryMenu();
                                if (queryChoice == 0) break;
                                if (queryChoice == 1) dm.queryAllDevices();
                                if (queryChoice == 2) dm.queryByName();
                            }
                            break;
                    }
                }
            }
        }
        System.out.println("系统已退出");
    }
}