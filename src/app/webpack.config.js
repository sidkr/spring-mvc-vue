const { VueLoaderPlugin } = require("vue-loader");
const htmlWebpackPlugin = require("html-webpack-plugin");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const autoprefixer = require("autoprefixer");
const path = require("path");
const webpack = require("webpack");

module.exports = (env, args) => {
    const config = {
        entry: {
            main: "./src/main.js",
        },
        resolve: {
            modules: [
                path.resolve(__dirname, 'node_modules'),
                path.resolve(__dirname, './'),
            ]
        },
        output: {
            filename: "[name].[contenthash:8].js",
            path: path.resolve(__dirname, "dist"),
            chunkFilename: "[name].[contenthash:8].js",
        },
        module: {
            rules: [{
                    test: /\.js$/,
                    exclude: /node_modules/,
                    use: {
                        loader: "babel-loader",
                    },
                },
                {
                    test: /\.vue$/,
                    loader: "vue-loader",
                },
                {
                    test: /\.s?css$/,
                    use: [
                        "style-loader",
                        MiniCssExtractPlugin.loader,
                        "css-loader",
                        {
                            loader: "postcss-loader",
                            options: {
                                plugins: () => [autoprefixer()],
                            },
                        },
                        "sass-loader",
                    ],
                },
                {
                    test: /\.(eot|ttf|woff|woff2)(\?\S*)?$/,
                    loader: "file-loader",
                },
                {
                    test: /\.(png|jpe?g|gif|webm|mp4|svg)$/,
                    loader: "file-loader",
                    options: {
                        name: "[name][contenthash:8].[ext]",
                        outputPath: "assets/img",
                        esModule: false,
                    },
                },
            ],
        },
        plugins: [
            new VueLoaderPlugin(),
            new CleanWebpackPlugin(),
            new MiniCssExtractPlugin({
                filename: "[name].[contenthash:8].css",
                chunkFilename: "[name].[contenthash:8].css",
            }),
            new htmlWebpackPlugin({
                template: path.resolve(__dirname, "public", "index.html"),
                // favicon: "./public/favicon.ico",
            }),
        ],
        resolve: {
            alias: {
                vue$: "vue/dist/vue.runtime.esm.js",
            },
            extensions: ["*", ".js", ".vue", ".json"],
        },
        optimization: {
            moduleIds: "hashed",
            runtimeChunk: "single",
            splitChunks: {
                cacheGroups: {
                    vendor: {
                        test: /[\\/]node_modules[\\/]/,
                        name: "vendors",
                        priority: -10,
                        chunks: "all",
                    },
                },
            },
        },
        devServer: {
            historyApiFallback: true,
            port: 3000,
        },
    };

    let df;
    if (args.mode === "dev" || args.mode === "development") {
        df = new webpack.DefinePlugin({
            isDev: true,
            isProd: false,
            apiBase: JSON.stringify("http://localhost:8080"),
        });
    } else {
        df = new webpack.DefinePlugin({
            isDev: false,
            isProd: true,
            apiBase: JSON.stringify(""),
        });
    }

    config.plugins.push(df);

    return config;
};