const CopyWebpackPlugin = require('copy-webpack-plugin')
const HtmlWebpackPlugin = require('html-webpack-plugin')
const CleanWebpackPlugin = require('clean-webpack-plugin')
const ExtractTextPlugin = require('extract-text-webpack-plugin')

module.exports = {
  entry:  {
    app: './h5/main.js',
    vendor: ['angular', 'angular-ui-router']
  },
  output: {
    path: __dirname + '/build/h5',
    filename: '[name].[hash:7].js'
  },
  module: {
    rules: [
      // {
      //   test: /\.css$/,
      //   use: ['style-loader', 'css-loader']
      // },
      {
        test: /\.(css|scss|sass)$/,
        use: ExtractTextPlugin.extract({
          fallback: "style-loader",
          use: [
            {
              loader: "css-loader"
            },
            {
              loader: 'sass-loader'
            }
          ]
        })
      },
      {
        test: /\.js$/,
        use: [{
          loader: 'babel-loader',
          options: {
            'env': 'es2015'
          }
        }]
      },
      {
        test: /\.html$/,
        use: [{
          loader: 'html-loader',
          options: {
            attrs: ['img:src']
          }
        }]
      },
      {
        test: /\.(png|jpg|gif|svg)$/,
        use: [{
          loader: 'url-loader',
          options: {
            limit: 8192,
            name: 'images/[name].[hash:7].[ext]',
          }
        }]
      },
      
    ]
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './h5/index.ejs',
      inject: 'body'
    }),
    new ExtractTextPlugin("styles.[hash:7].css"),
    // new CopyWebpackPlugin([{
    //   from: __dirname + '/app/modules/',
    //   to: __dirname + '/build/modules',
    //   ignore: ['*.js', '*.css']
    // }]),
    new CleanWebpackPlugin(
      ['*'],
      {
        root: __dirname + '/build',
        verbose: true,
        dry: false
      }
    )
  ],
  optimization: {
    splitChunks: {
      cacheGroups: {
        commons: {
          name: "vendor",
          chunks: "initial",
          minChunks: 2
        }
      }
    }
  },
}