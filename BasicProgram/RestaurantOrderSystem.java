import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RestaurantOrderSystem {

    public static void main(String[] args) {
        // 菜单
        Map<String, Double> menu = new HashMap<>();
        menu.put("汉堡", 5.99);
        menu.put("披萨", 8.99);
        menu.put("沙拉", 3.99);
        menu.put("饮料", 1.99);

        // 创建一个 Scanner 对象来接收用户输入
        Scanner scanner = new Scanner(System.in);

        // 用户点餐
        Map<String, Integer> order = new HashMap<>();
        boolean continueOrdering = true;

        while (continueOrdering) {
            System.out.println("菜单:");
            for (String item : menu.keySet()) {
                System.out.println(item + ": $" + menu.get(item));
            }

            System.out.print("请输入您要点的食物 (输入 '完成' 结束点餐): ");
            String foodItem = scanner.nextLine();

            if (foodItem.equalsIgnoreCase("完成")) {
                continueOrdering = false;
            } else if (menu.containsKey(foodItem)) {
                System.out.print("请输入数量: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // 消耗掉输入缓冲区中的换行符

                order.put(foodItem, quantity);
            } else {
                System.out.println("抱歉，我们没有这道菜，请重新选择。");
            }
        }

        // 计算总价格
        double total = calculateTotal(menu, order);

        // 打印订单和总价格
        System.out.println("\n您的订单:");
        for (String item : order.keySet()) {
            int quantity = order.get(item);
            double price = menu.get(item);
            System.out.println(item + " x " + quantity + ": $" + (quantity * price));
        }
        System.out.println("总价格: $" + total);

        // 关闭 Scanner 对象，释放资源
        scanner.close();
    }

    // 计算总价格
    private static double calculateTotal(Map<String, Double> menu, Map<String, Integer> order) {
        double total = 0;

        for (String item : order.keySet()) {
            int quantity = order.get(item);
            double price = menu.get(item);
            total += quantity * price;
        }

        return total;
    }
}
