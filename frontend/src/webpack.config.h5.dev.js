const webpackMerge = require('webpack-merge')
const base = require('./webpack.config.h5.base.js')

module.exports = webpackMerge(base, {
  devtool: 'source-map',
  devServer: {
    contentBase: './build/h5',
    historyApiFallback: true,
    inline: true,
    port: 8081
  },
})