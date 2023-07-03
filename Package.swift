// swift-tools-version:5.3
import PackageDescription

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://maven.pkg.github.com/jeryRazakarison/kmmtry/com/jery/kmmbridgekickstart/allshared-kmmbridge/0.1.2/allshared-kmmbridge-0.1.2.zip"
let remoteKotlinChecksum = "9280f2777acb8a247cd997b747bad1bb776651f6c7fd3cd3ec537ceb6918a6fe"
let packageName = "FRAMEWORK_NAME"
// END KMMBRIDGE BLOCK

let package = Package(
    name: packageName,
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: packageName,
            targets: [packageName]
        ),
    ],
    targets: [
        .binaryTarget(
            name: packageName,
            url: remoteKotlinUrl,
            checksum: remoteKotlinChecksum
        )
        ,
    ]
)