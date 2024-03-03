import UIKit
import SwiftUI
import shared
import Metal

@main
struct iosApp: App {
    func metal()-> String {
        let device = MTLCreateSystemDefaultDevice()
        print(device ?? "")
        return ""
    }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

struct ContentView: View {
    var body: some View {
        ComposeView().ignoresSafeArea(.all)
    }
}

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}


